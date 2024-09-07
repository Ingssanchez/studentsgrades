/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package notafinal;
/*Programa con arreglo tipo matriz que capture las 3 calificaciones de un curso de n estudiantes, (máximo 50) para un curso de la universidad. Las notas son valores decimales entre 0 y 5, y deben validarse. 1. La nota final se calcula en promedio aritmético y almacenarlo en un vector, 2. debe calcular la definitiva promedio ponderado, de la siguiente forma nota 1 vale 25%, nota 2 vale 30%, nota 3 vale 45%. Esta nueva nota debe almacenarse en otro vector.3. determine la cantidad de alumnos que pasan el curso usando cada uno de los métodos de calculo de la definitiva anteriores. 4. Determine la nota máxima y minina de la nota1, nota2, nota3.
/**
 *
 * @author SERGIO SANCHEZ 20241222424
 */
import java.util.Scanner;

public class Notafinal {

    public static void main(String[] args) {
        final int MAX_ESTUDIANTES = 50;
        final int NUM_NOTAS = 3;
        float[][] calificaciones = new float[MAX_ESTUDIANTES][NUM_NOTAS];
        float[] notasFinalesPromedio = new float[MAX_ESTUDIANTES];
        float[] notasFinalesPonderado = new float[MAX_ESTUDIANTES];

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de estudiantes (máximo 50): ");
        int n = scanner.nextInt();
        n = Math.min(n, MAX_ESTUDIANTES);

        // Ingreso y validación de calificaciones
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < NUM_NOTAS; j++) {
                do {
                    System.out.print("Ingrese la calificación " + (j + 1) + " para el estudiante " + (i + 1) + ": ");
                    calificaciones[i][j] = scanner.nextFloat();
                } while (calificaciones[i][j] < 0 || calificaciones[i][j] > 5);
            }
        }

        // 1. Cálculo de la nota final por promedio aritmético
        for (int i = 0; i < n; i++) {
            float suma = 0;
            for (int j = 0; j < NUM_NOTAS; j++) {
                suma += calificaciones[i][j];
            }
            notasFinalesPromedio[i] = suma / NUM_NOTAS;
        }

        // 2. Cálculo de la nota final por promedio ponderado
        float[] pesos = {0.25f, 0.30f, 0.45f}; 
        for (int i = 0; i < n; i++) {
            float sumaPonderada = 0;
            for (int j = 0; j < NUM_NOTAS; j++) {
                sumaPonderada += calificaciones[i][j] * pesos[j];
            }
            notasFinalesPonderado[i] = sumaPonderada;
        }

        // 3. Cantidad de alumnos que pasan el curso
        int aprobadosPromedio = 0;
        int aprobadosPonderado = 0;
        float notaMinimaAprobacion = 3.0f; // Ajustar según el criterio de aprobación

        for (int i = 0; i < n; i++) {
            if (notasFinalesPromedio[i] >= notaMinimaAprobacion) {
                aprobadosPromedio++;
            }
            if (notasFinalesPonderado[i] >= notaMinimaAprobacion) {
                aprobadosPonderado++;
            }
        }

        System.out.println("Aprobados por promedio aritmético: " + aprobadosPromedio);
        System.out.println("Aprobados por promedio ponderado: " + aprobadosPonderado);

        // 4. Notas máximas y mínimas por cada calificación
        float[] notasMaximas = {calificaciones[0][0], calificaciones[0][1], calificaciones[0][2]};
        float[] notasMinimas = {calificaciones[0][0], calificaciones[0][1], calificaciones[0][2]};

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < NUM_NOTAS; j++) {
                notasMaximas[j] = Math.max(notasMaximas[j], calificaciones[i][j]);
                notasMinimas[j] = Math.min(notasMinimas[j], calificaciones[i][j]);
            }
        }

        System.out.println("Nota máxima 1: " + notasMaximas[0]);
        System.out.println("Nota mínima 1: " + notasMinimas[0]);
        System.out.println("Nota máxima 2: " + notasMaximas[1]);
        System.out.println("Nota mínima 2: " + notasMinimas[1]);
        System.out.println("Nota máxima 3: " + notasMaximas[2]);
        System.out.println("Nota mínima 3: " + notasMinimas[2]);

        scanner.close();
    }
}