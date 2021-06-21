package com.company;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class FROGJUMP {
    public static void main(String[] args) {
        //-----------------------------------BFS--------------------------------
        Scanner input = new Scanner(System.in);
        System.out.print("Insert the number of positions: ");

        int position = input.nextInt();
        if (position == 0) {
            System.out.println("No jumps!");
        } else {


            Graph graph = new Graph(position);
            char[] vertex = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N'};

            for (int i = 0; i < position; i++) {
                graph.addVertex(vertex[i]);
            }

            graph.printVertes();

            graph.addingLiliPads();
            System.out.print("BFS Visits\n\t: ");
            graph.bfs();
        }
        System.out.println();
        //------------------------------------DFS----------------------------------\\

      /*Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 3);

        System.out.print ("Visits: ");
        graph.dfs();
        System.out.println();
*/

    }
}

//---------------------------------BFS Using Adjacency Matrix------------------------------------

class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char lab) {
        label = lab;
        wasVisited = false;
    }
}

class Graph {
    private final int MAX_VERTS;
    public Vertex vertexList[];
    public int adjMat[][];
    private int nVerts;
    private Queue<Integer> q;
    Scanner input = new Scanner(System.in);

    public Graph(int length) {

        this.MAX_VERTS = length;
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        q = new LinkedList<Integer>();
        int k = 0;
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                adjMat[i][j] = 100 + k;
                k++;
            }

        }
    }

    public void addingLiliPads() {

        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[i].length; j++) {
                if (adjMat[i][j] != adjMat[j][i]) {
                    System.out.println("\nDoes LiliPad Exists in Position : " + i + " Position : " + j);
                    System.out.print("Enter\n\t\"1\" for exist Path\n\t\"0\" for no path\n\t: ");
                    int in = input.nextInt();
                    if (in == 1) {
                        addEdge(i, j, in);
                    } else if (in == 0) {
                        addEdge(i, j, in);
                    }
                }
            }
        }


    }

    public void addVertex(char lab) {
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end, int in) {
        adjMat[start][end] = in;
        adjMat[end][start] = in;
    }

    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + " ");
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++) {
            if (adjMat[v][j] == 1 && !vertexList[j].wasVisited) {
                return j;
            }
        }
        return -1;
    }

    public void bfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        q.add(0);
        int v2;

        while (!q.isEmpty()) {
            int v1 = q.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                q.add(v2);
            }
        }
    }

    public void printVertes() {
        for (int i = 0; i < nVerts; i++)
            System.out.println("Position: " + vertexList[i].label);

    }
}


//-------------------------------DFS Using Adjacency Matrix---------------------------------
/*

class Vertex{
    public char label;
    public boolean wasVisited;

    public Vertex(char lab){
        label = lab;
        wasVisited = false;

    }
}

class Graph{
    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;
    private Stack<Integer> s;

    public Graph(){
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        s = new Stack<Integer>();

    }

    public void addVertex(char lab){
        vertexList[nVerts++] = new Vertex(lab);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;

    }

    public void displayVertex(int v){
        System.out.print(vertexList[v].label + " ");
    }

    public int getAdjUnvisitedVertex(int v){
        for(int j = 0; j < nVerts; j++){
            if(adjMat[v][j] == 1 && vertexList[j].wasVisited == false){
                return j;
            }
        }
        return -1;
    }

    public void dfs(){
        vertexList[0].wasVisited = true;
        displayVertex(0);
        s.push(0);

        while (!s.isEmpty()){
            int v = getAdjUnvisitedVertex(s.peek());

            if(v == -1){
                s.pop();
            }
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                s.push(v);
            }
        }
    }
}*/
