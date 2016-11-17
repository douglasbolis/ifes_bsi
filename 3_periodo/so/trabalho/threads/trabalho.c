/*
 * trabalho v1.c
 *
 * Copyright 2016 Icaro <icaro@gavazza>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 *
 *
 */
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

#define TAMLINHA 5
#define TAMCOLUNA 5
#define MAXRANDOM 20

int _contadorPrimos = 0;

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

void add_linha(void **matriz, int numLinha) {
    matriz[numLinha] = malloc(TAMCOLUNA*sizeof(int));
}

void add_num_lin(int *linha) {
    int i;

    srand(clock());
    for(i = 0; i < TAMCOLUNA; i++) {
        linha[i] = rand() %MAXRANDOM;
    }

}

void add_num(void **matriz) {
    int i;

    for(i = 0; i < TAMLINHA; i++) {
        add_num_lin(matriz[i]);
    }
}

void imprime_matriz(void **matriz) {
    int i, j, *lin;

    for(i = 0; i < TAMLINHA; i++){
        lin = matriz[i];
        for(j = 0; j < TAMCOLUNA; j++){
            printf(" %5d ", lin[j]);
        }
        printf("\n");
    }
}

void busca_serial(void **matriz) {
    int i, j, *lin;

    for(i = 0; i < TAMLINHA; i++){
        lin = matriz[i];
        for(j = 0; j < TAMCOLUNA; j++){
            _contadorPrimos += eh_primo(lin[j]);
        }
    }
}

int main(int argc, char **argv){
    int i;
    void **matriz;

    matriz = malloc(TAMLINHA*sizeof(unsigned long int));
    for(i = 0; i < TAMLINHA; i++){
        add_linha(matriz, i);
    }

    add_num(matriz);
    imprime_matriz(matriz);
    busca_serial(matriz);

    printf("\nQuantidade de números primos na matriz: %d", _contadorPrimos);

    return 0;
}
