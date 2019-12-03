/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.JPanel;

/**
 * Clase GrafoG representa vertices y aristas para construir grafo graficamente.
 * @author wildg
 */
public class GrafoG {
    private LinkedList<Vertice> vertices ;
    private LinkedList<Arista> aristas ;
    private JPanel window;

    /**
     * Constructor clase GrafoG
     * @param window: JFrame donde se dibujará el grafo.
     */
    public GrafoG(JPanel window) {
        vertices = new LinkedList();
        aristas = new LinkedList();
        this.window = window;
    }

    /**
     * Función que retorna aristas del grafo.
     * @return LinkedList aristas del grafo.
     */
    public LinkedList<Arista> getAristas() {
        return aristas;
    }
    
    
    /**
     * Función que retorna vértices del grafo.
     * @return LinkedList de vértices del grafo.
     */
    public LinkedList<Vertice> getVertices() {
        return vertices;
    }
    
    
    /**
     * Metodo para agregar un vértice al grafo.
     * @param xc int posición x del clic en pantalla.
     * @param yc int posición y del clic en pantalla.
     * @param nombre String con el nombre del vértice.
     */
    public void addVertice(int xc, int yc, String nombre){
        int x=xc-(Vertice.getD()/2);
        int y=yc-(Vertice.getD()/2);
        Rectangle nuevoRectangulo = new Rectangle(x, y, Vertice.getD(), Vertice.getD());
        int i=0;
        boolean sw=false;
        while(i<vertices.size() && !sw){
            if(vertices.get(i).getAreaOcupada().intersects(nuevoRectangulo)){
                sw=true;
            }
            i++;
        }
        if(!sw){
            this.vertices.add(new Vertice(x,y,nombre));
            //window.dibujar();
        } else{
            //window.mensaje("Se intersecan");
        } 
        
    }
    
    
    /**
     * Método para agregar arista al grafo.
     * @param v1 vértice inicial.
     * @param v2 vértice final.
     */
    public void addArista(Vertice v1, Vertice v2, int distancia){
        if(v1.esAdyacenteA(v2)){
            this.aristas.add(new Arista(v1,v2,(buscarArista2(vertices.indexOf(v1),vertices.indexOf(v2)).getDistancia())));
        }else {
            this.aristas.add(new Arista(v1,v2,distancia));
        }
        
    }
    
    
    /**
     * Método para borrar vértice seleccionado.
     * @param vertice vertice seleccionado.
     */
    public void borrarVertice(Vertice vertice){
        //window.mensaje("se eliminó el vertice "+vertice.getNombre());
        for (Arista arista : vertice.getAristas()) {
            aristas.remove(arista);
        }
        vertice.borrar();
        vertices.remove(vertice);
    }
    
    
    /**
     * Método para borrar arista entre los vértices seleccionados.
     * @param v1 vertice inicial.
     * @param v2 vertice final.
     */
    public void borrarArrista(Vertice v1, Vertice v2){
        if(v1.esAdyacenteA(v2)){
            //window.mensaje("se eliminara arista de "+v1.getNombre()+" a "+v2.getNombre());
            Arista arista = v1.buscarArista(v2);
            arista.borrar();
            aristas.remove(arista);
        }else {
            //window.mensaje(v1.getNombre()+" no es adyacente a "+v2.getNombre());
        }
    }
    
    
    /**
     * Función para crear un objeto con la estructura de datos de un gráfo a 
     * partir de las aristas de GrafoG.
     * @return Grafo 
     */
    private Grafo crearGrafo(){
        Grafo grafo = new Grafo(vertices.size());
        for (Arista arista : aristas) {
            grafo.addArista(vertices.indexOf(arista.getInicio()), vertices.indexOf(arista.getFin()),arista.getDistancia());
        }
        grafo.showL();
        return grafo;
    }
    
    
    
    
    
    public String Eulers(){
        if(!aristas.isEmpty()){
            Grafo grafo = crearGrafo();
            return grafo.esEuleriano();
        }else {
            return "No hay aristas";
        }
    }
    
    public ArrayList<Arista> Dijkstra(Vertice v,Vertice p){
        ArrayList<Arista> camino = new ArrayList();
        if(!aristas.isEmpty()){
            Grafo grafo = crearGrafo();
            int inicio = vertices.indexOf(v);
            int fin = vertices.indexOf(p);
            int [] pa = grafo.dijkstra(inicio);
            int i=fin;
            System.out.println(Arrays.toString(pa));
            while(i!=inicio){
                camino.add(buscarArista(pa[i],i));
                i=pa[i];
            }
            
        }
        return camino;
    }
    
    private Arista buscarArista(int a, int b){
        for (Arista arista : aristas) {
            if((vertices.get(a)==arista.getInicio() && vertices.get(b)==arista.getFin())){
                return arista;
            }
        }
        return null;
    }
    
    private Arista buscarArista2(int a, int b){
        for (Arista arista : aristas) {
            if((vertices.get(a)==arista.getInicio() && vertices.get(b)==arista.getFin()) || (vertices.get(b)==arista.getInicio() && vertices.get(a)==arista.getFin())){
                return arista;
            }
        }
        return null;
    }
    
    /**
     * Metodo para dibujar los vértices y aristas del grafo.
     * @param g Graphics del panel donde se dibujará el grafo.
     * @param color Color con que se dibujaran las aristas
     * @param sw boolean true para escribir distancia de la arista o false para
     * no escribirla.
     */
    public void dibujarGrafo(Graphics g, Color color,  boolean sw){
        for (Arista arista : aristas) {
            arista.pintar(g,color,sw);
        }
        for (Vertice vertice : vertices) {
            vertice.pintar(g);
        }
    }
    
    
    public void generarGrafo(int nV, int[][] mat){
        vertices = new LinkedList();
        aristas = new LinkedList();
        while(vertices.size()<nV){
            int x = ((int)(Math.random()*(window.getWidth())-(Vertice.getD()/2)));
            int y = ((int)(Math.random()*(window.getHeight())-(Vertice.getD()/2)));
            if(x<(Vertice.getD()/2)) x=(Vertice.getD()/2);
            if(y<(Vertice.getD()/2)) y=(Vertice.getD()/2);
            addVertice(x,y,Integer.toString(vertices.size()+1));
        }
        for (int i = 0; i < nV; i++) {
            for (int j = 0; j < nV; j++) {
                if(mat[i][j]>0){
                    addArista(vertices.get(i),vertices.get(j),(int) (Math.random()*100));
                }
            }
        }
    }
    
    public boolean esDirigido(){
        Grafo g = crearGrafo();
        return g.esDirigido();
    }
    
    /**
     *Método para colocar los vértices de color negro.
     */
    public void setVerticesBlack(){
        vertices.forEach((vertice) -> { vertice.setColor(Color.BLACK); });
    }
    
    public String dfs(){
         Grafo g = crearGrafo();
        return "DFS: "+g.DFS(0).toString(); 
    }
    
    /**
     * Función para saber si el grafo tiene al menos un vertice.
     * @return boolean true si tiene vertices, false si no.
     */
    public boolean hasVertices(){
        return !vertices.isEmpty();
    }
    
    /**
     * Función para saber si el grafo tiene al menos una arista.
     * @return boolean true si tiene aristas, false si no.
     */
    public boolean hasEdges(){
        return !aristas.isEmpty();
    }
    
    /**
     * Método para obtener vértice ubicado en la posición del clic.
     * @param point punto donde se dió clic.
     * @return Vertice ubicado en la posición del clic.
     */
    public Vertice getVertice(Point point){
        int i = 0;
        Vertice vertice = null;
        boolean sw=false;
        while(i<vertices.size()&& !sw){
            Vertice temp = vertices.get(i);
            if(temp.getAreaOcupada().contains(point)){
                sw = true;
                vertice = temp;
            }else {
                i++;
            }
        }
        return vertice;
    }
}
