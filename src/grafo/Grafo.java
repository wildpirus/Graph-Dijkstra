/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Clase para la estructura de datos de un grafo no dirigido ponderado.
 * @author wildg
 */
class Grafo {
    private int nV;
    private boolean matAdyacencia[][];
    private int matDistancia[][];
    private LinkedList<Integer>[] lista;
    private int INF = Integer.MAX_VALUE;
    
    
    /**
     * Constructor para clase Grafo, no dirigido.
     * @param nV: número de vertices que tiene el grafo.
     */
    public Grafo(int nV) {
        this.nV = nV;
        matAdyacencia = new  boolean[nV][nV];
        lista = new LinkedList[nV]; 
        for (int i=0; i<nV; ++i) {
            lista[i] = new LinkedList(); 
        }
        matDistancia = new int[nV][nV];
    }

    
    /**
     * Metodo para agregar una arista al grafo no dirigido
     * @param source: primer vertice adyacente sw la arista.
     * @param destiny: segundo vertice adyacente sw la arista.
     * @param distancia: int distancia entre los dos vertices adyacentes sw la 
     * arista. 
     */
    public void addArista(int source, int destiny, int distancia) {
        matAdyacencia[source][destiny]=true;
        lista[source].add(destiny);
        matDistancia[source][destiny]=distancia;
    }
    
    public boolean esDirigido(){
        for (int i = 0; i < nV; i++) {
            for (int j = i+1; j < nV; j++) {
                if(matAdyacencia[i][j]!=matAdyacencia[j][i]){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Metodo que escribe en consola la matriz de adyacencia del grafo.
     */
    public void showM() {
        for (int i = 0; i < matAdyacencia.length; i++) {
            for (int j = 0; j < matAdyacencia.length; j++) {
                if(matAdyacencia[i][j]){
                    System.out.print(matAdyacencia[i][j]+" |");
                }else {
                    System.out.print(matAdyacencia[i][j]+"|");
                }
            }
            System.out.println("");
        }
    }
    
    
    /**
     * Metodo que escribe en consola la lista de adyacencia del grafo.
     */
    public void showL() {
        System.out.println("Lista de Adyacencia");
        int i=0;
        for (LinkedList<Integer> linkedList : lista) {
            System.out.print((i+1)+"|");
            linkedList.forEach((integer) -> {
                System.out.print("->"+(integer+1)+"|");
            });
            System.out.println("");
            i++;
        }
    }
    
    
    //Conexo--------------------------------------------------------------------
    /**
     * Método para realizar recorrido DFS sw partir de la lista de adyacencia del
     * grafo.
     * @param v: número de vertices.
     * @param visitados: arreglo para guardar los vertices que se van visitando.
     */
    private void DFSUtil(int v,boolean[] visitados) { 
        visitados[v] = true; 
  
        Iterator<Integer> i = lista[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visitados[n]) 
                DFSUtil(n, visitados); 
        } 
    } 
  
    /**
     * Función para determinar si en el grafo se puede llegar de un vértice sw 
     * otro siguiendo un camino de aristas usando el recorrido DFS y la lista de
     * adyacencia del grafo.
     * @return true si es conexo, falso si no es conexo.
     */
    public boolean esConexo() { 
        boolean[] visitados = new boolean[nV]; 
        int i; 
        for (i = 0; i < nV; i++) visitados[i] = false; 
        
        i--;
        DFSUtil(i, visitados); 
  
        for (i = 0; i < nV; i++) 
           if (visitados[i] == false && lista[i].size() > 0) 
                return false; 
  
        return true; 
    }
    
    
    //Euler---------------------------------------------------------------------
    private boolean esConexoG0() { 
        boolean visited[] = new boolean[nV]; 
        int i; 
        for (i = 0; i < nV; i++) 
            visited[i] = false; 
  
        for (i = 0; i < nV; i++) 
            if (lista[i].size() != 0) 
                break; 
  
        if (i == nV) 
            return true; 
  
        DFSUtil(i, visited); 
  
        for (i = 0; i < nV; i++) 
           if (visited[i] == false && lista[i].size() > 0) 
                return false; 
  
        return true; 
    } 
  
    public String esEuleriano() { 
        if (esConexoG0() == false) 
            return "El grafo no es euleriano"; 
  
        int odd = 0; 
        for (int i = 0; i < nV; i++) 
            if (lista[i].size()%2!=0) 
                odd++; 
  
        if (odd > 2) 
            return "El grafo no es euleriano"; 
  
        return (odd==2)? "El grafo tiene un camino Euleriano (Semieuleriano)" : "El grafo tiene un ciclo Euleriano"; 
    } 
    
    
    
    private int minDistance(int dist[], Boolean sptSet[]) { 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < nV; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    private void distDijks(int dist[]){ 
        System.out.println("Vertice \t\t Distancia desde el inicio"); 
        for (int i = 0; i < nV; i++) 
            System.out.println(i + " \t\t " + dist[i]); 
    } 
  
    public int[] dijkstra(int inicio) { 
        int[] antecesores = new int[nV]; 
        int[] vec1 = new int[nV];
  
        Boolean[] vec2 = new Boolean[nV]; 
  
        for (int i = 0; i < nV; i++) { 
            vec1[i] = Integer.MAX_VALUE; 
            vec2[i] = false; 
        } 
  
        vec1[inicio] = 0; 
  
        for (int count = 0; count < nV - 1; count++) { 
            int u = minDistance(vec1, vec2); 
  
            vec2[u] = true; 
  
             
            for (int v = 0; v < nV; v++) 
  
                if (!vec2[v] && matDistancia[u][v] != 0 && vec1[u] != Integer.MAX_VALUE && vec1[u] + matDistancia[u][v] < vec1[v]){ 
                    vec1[v] = vec1[u] + matDistancia[u][v];
                    antecesores[v] = u; 
                }   
        } 
  
        distDijks(vec1); 
        printCamino(antecesores);
        return antecesores;
    }
    
    void printCamino(int parent[]) { 
        System.out.println("Predecesor \tVertice"); 
        for (int i = 1; i < nV; i++) 
            System.out.println(parent[i] + "\t\t" + i ); 
    }
    
    void DFSUtil2(int v,boolean visited[],ArrayList<Integer> a) { 
        visited[v] = true; 
        System.out.print(v+" "); 
        a.add(v);
        Iterator<Integer> i = lista[v].listIterator(); 
        while (i.hasNext()) 
        { 
            int n = i.next(); 
            if (!visited[n]) 
                DFSUtil2(n, visited,a); 
        } 
    } 
  
    public ArrayList<Integer> DFS(int v) { 
        boolean visited[] = new boolean[nV]; 
        ArrayList<Integer> a = new ArrayList();
        DFSUtil2(v, visited,a); 
        return a;
    } 
}
