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
#include <time.h>

#define TAMLINHA 10
#define TAMCOLUNA 10
#define MAXRANDOM 29999

void add_linha(void **matriz, int numLinha) {
    matriz[numLinha] = malloc(TAMLINHA*sizeof(int));
}

void add_num_lin(int *linha) {
    int i;

    srand(clock());
    for(i = 0; i < TAMLINHA; i++) {
        linha[i] = rand() %MAXRANDOM;
    }

}

void add_num(void **matriz) {
    int i;

    for(i = 0; i < TAMCOLUNA; i++) {
        add_num_lin(matriz[i]);
    }
}

void imprime_matriz(void **matriz) {
    int i, j, *lin;

    for(i = 0; i < TAMCOLUNA; i++){
        lin = matriz[i];
        for(j = 0; j < TAMLINHA; j++){
            printf(" %5d ", lin[j]);
        }
        printf("\n");
    }
}

int main(int argc, char **argv){
    int i;
    void **matriz;

    matriz = malloc(TAMCOLUNA*sizeof(unsigned long int));
    for(i = 0; i < TAMCOLUNA; i++){
        add_linha(matriz, i);
    }

    add_num(matriz);
    imprime_matriz(matriz);

    return 0;
}
