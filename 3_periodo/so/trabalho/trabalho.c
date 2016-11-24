/*
 * trabalho.c
 *
 * Copyright 2016 Douglas <douglas@bolis> Icaro <icaro@gavazza> Tadeu <tadeu@jr>
 */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
/* pegar o tempo no linux */
#include <sys/time.h>
#include <pthread.h>

/* Características da Matriz */
#define TAMLINHA 20000
#define TAMCOLUNA 20000
#define MAXRANDOM 29999

/* Multithread */
#define NUMTHREADS 4096
#define MBLINHA 100
#define MBCOLUNA 100

int **matriz;
unsigned int _contadorPrimos;
/* Macroblocos disponíveis */
unsigned int _MBDisponiveis;
pthread_mutex_t _mutexNumPrimo;
pthread_mutex_t _mutexMBDisponiveis;

typedef struct {
    int linhaI, linhaF, colunaI, colunaF;
} macroBloco;

/**
 * Assinatura dos métodos
 */
int eh_primo(int);
void add_num_lin(int*);
void add_num();
void imprime_matriz();
void busca_serial();
void *busca_paralelo();
void set_me_free();
void cria_matriz();

/**
 * Método principal
 */
int main(int argc, char **argv) {
    int tempoMili, t=0, ml, mc, ret=0;
    struct timeval inicioSerial, finalSerial, inicioParalelo, finalParelelo;
    macroBloco* macroblocos;
    pthread_t threads[NUMTHREADS];

    /* Iniciando mutex */
    pthread_mutex_init(&_mutexNumPrimo, NULL);
    pthread_mutex_init(&_mutexMBDisponiveis, NULL);

    /* cria a matriz */
    cria_matriz();
    /* adicionando números aleatórios */
    add_num();

    /* INÍCIO BUSCA SERIAL */
    gettimeofday(&inicioSerial, NULL);
    _contadorPrimos = 0;
    busca_serial();
    printf("\nBUSCA SERIAL\nQuantidade de números primos na matriz: %u\n", _contadorPrimos);
    gettimeofday(&finalSerial, NULL);
    tempoMili = (int) (1000 * (finalSerial.tv_sec - inicioSerial.tv_sec) + (finalSerial.tv_usec - inicioSerial.tv_usec) / 1000);
    printf("Tempo decorrido: %d ms\n", tempoMili);
    /* FIM BUSCA SERIAL */
    
    /* INÍCIO BUSCA PARALELA */
    _contadorPrimos = 0;
    gettimeofday(&inicioParalelo, NULL);
    /* Definindo vetor para gerenciar os macroblocos disponiveis.
     * Para determinar a quantidade de macroblocos:
     *  · dividindo quantidade de elementos da matriz pela quantidade de elementos do macrobloco definidos por (linha * coluna) de ambos.
     */
    _MBDisponiveis = (TAMLINHA * TAMCOLUNA) / (MBLINHA * MBCOLUNA);
    macroblocos = (macroBloco*)malloc(_MBDisponiveis * sizeof(macroBloco));
    
    for (ml = 0; ml<TAMLINHA; ml += MBLINHA)
		for (mc = 0; mc<TAMCOLUNA; mc += MBCOLUNA) {
			macroblocos[t].linhaI = ml;
			macroblocos[t].linhaF = ml + MBLINHA;
			macroblocos[t].colunaI = mc;
			macroblocos[t].colunaF = mc + MBCOLUNA;
			t++;
		}
	
	/* CRIANDO THREADS */	
	for (t = 0; t<NUMTHREADS; t++) {
		/* INICIA AS THREADS COM UMA LISTA DE MACROBLOCOS COMO PARAMETRO */
		ret = pthread_create(&threads[t], NULL, busca_paralelo, (void*)macroblocos);
		if (ret) printf("\n Erro: %d \n",ret);
	}
	
	for (t = 0; t< NUMTHREADS; t++) {
		pthread_join(threads[t], NULL);
	}
	
    printf("\nBUSCA PARALELA\nQuantidade de números primos na matriz: %u\n", _contadorPrimos);
    gettimeofday(&finalParelelo, NULL);
    tempoMili = (int) (1000 * (finalParelelo.tv_sec - inicioParalelo.tv_sec) + (finalParelelo.tv_usec - inicioParalelo.tv_usec) / 1000);
    printf("Tempo decorrido: %d ms\n", tempoMili);
    
    /* FIM BUSCA PARALELA */

    /* Liberando memória alocada na matriz */
    set_me_free();
    return 0;
}


/**
 * Verifica se n é primo
 * @param n
 * @return
 */
int eh_primo(int n) {
    int i, ctrl;
    double limite;

    if (n == 2) {
        return 1;
    } else if (n < 2 || n % 2 == 0) {
        return 0;
    } else {
        i = 3;
        ctrl = 1;
        limite = sqrt(n) + 1;
        while (i < limite && ctrl) {
            if (n % i == 0) {
                ctrl = 0;
            }
            i += 2;
        }
        return ctrl;
    }
}

/**
 * Uma nova linha será alocada para a posição numLinha da matriz
 * @param numLinha
 */

void add_num_lin(int *linha) {
    int i;

    srand(clock());
    for(i = 0; i < TAMCOLUNA; i++) {
        linha[i] = rand() %MAXRANDOM;
    }
}

void add_num() {
    int i;

    for(i = 0; i < TAMLINHA; i++) {
        add_num_lin(matriz[i]);
    }
}

void imprime_matriz() {
    int i, j, *lin;

    for(i = 0; i < TAMLINHA; i++) {
        lin = matriz[i];
        for(j = 0; j < TAMCOLUNA; j++) {
            printf(" %5d ", lin[j]);
        }
        printf("\n");
    }
}

void busca_serial() {
    int i, j, *lin;

    for(i = 0; i < TAMLINHA; i++) {
        lin = matriz[i];
        for(j = 0; j < TAMCOLUNA; j++) {
            _contadorPrimos += eh_primo(lin[j]);
        }
    }
}

void set_me_free() {
    int i, *linha;
    for (i = 0; i < TAMCOLUNA; i++) {
        linha = matriz[i];
        free(linha);
    }
    free(matriz);
}

void cria_matriz(){
    int i;
    matriz = malloc(TAMLINHA*sizeof(unsigned long));

    for(i = 0; i < TAMCOLUNA; i++) {
		matriz[i] = malloc(TAMCOLUNA*sizeof(int));
    }
}
void *busca_paralelo(void *macroblocos) {
	macroBloco mb;
	int i = 0, j = 0, fimdatreta = 0, nprimos = 0 ;
	
	while (1) {
		/* região critica dos macroblocos */
		pthread_mutex_lock(&_mutexMBDisponiveis);
		if (_MBDisponiveis >= 1) {
			mb = ((macroBloco*)macroblocos)[_MBDisponiveis - 1];
			_MBDisponiveis--;
		} else {
			fimdatreta = 1;
		}
		pthread_mutex_unlock(&_mutexMBDisponiveis);
		/* fim da região critica */
		
		/* finaliza a tread se não houver mais trampo */
		if (fimdatreta) pthread_exit(NULL);
		nprimos = 0;
		/* conta os os primos do macribloco */
		for (i = mb.linhaI; i<mb.linhaF; i++) {
			for (j = mb.colunaI; j<mb.colunaF; j++) {
				if (eh_primo(matriz[i][j])) {
					nprimos++;
				}
			}
		}
		/* Região critica onde passa os primos contados do macrobloco para o contador global */
		pthread_mutex_lock(&_mutexNumPrimo);
		_contadorPrimos += nprimos;
		pthread_mutex_unlock(&_mutexNumPrimo);
	}
}
