# Graphs in Java: A Complete Guide

---

## Table of Contents

1. [What is a Graph?](#what-is-a-graph)
2. [Key Terminology](#key-terminology)
3. [Adjacency Explained](#adjacency-explained)
4. [Undirected Graphs](#undirected-graphs)
5. [Directed Graphs (Digraphs)](#directed-graphs-digraphs)
6. [Adjacency Matrix](#adjacency-matrix)
7. [Adjacency List](#adjacency-list)
8. [Comparison: Matrix vs List](#comparison-matrix-vs-list)
9. [Summary](#summary)

---

## What is a Graph?

A **graph** is a data structure made up of two things:

- **Vertices (Nodes)** — the individual entities (e.g., cities, people, web pages)
- **Edges** — connections between pairs of vertices

Graphs are used everywhere: social networks, maps, dependency resolvers, network routing, and more.

```
Example graph with 4 vertices and 4 edges:

    A --- B
    |     |
    D --- C
```

Here, `A`, `B`, `C`, and `D` are **vertices**. The lines between them are **edges**.

---

## Key Terminology

| Term | Meaning |
|------|---------|
| **Vertex / Node** | A single point in the graph |
| **Edge** | A connection between two vertices |
| **Degree** | Number of edges connected to a vertex |
| **Path** | A sequence of vertices connected by edges |
| **Cycle** | A path that starts and ends at the same vertex |
| **Weight** | An optional value assigned to an edge (e.g., distance) |
| **Adjacent** | Two vertices directly connected by an edge |

---

## Adjacency Explained

**Adjacency** is one of the most fundamental concepts in graph theory.

Two vertices are said to be **adjacent** if there is a **direct edge** between them. No intermediate vertices — just a single edge connecting them.

```
    A --- B --- C
          |
          D
```

- `A` and `B` are **adjacent** (direct edge between them)
- `B` and `C` are **adjacent**
- `B` and `D` are **adjacent**
- `A` and `C` are **NOT adjacent** (no direct edge; they connect through `B`)
- `A` and `D` are **NOT adjacent**

### Why Does Adjacency Matter?

Adjacency determines:
- **Traversal** — which vertices can you visit next from your current position?
- **Connectivity** — can you reach vertex X from vertex Y?
- **Representation** — how you store the graph in memory (matrix or list)

### In-Degree and Out-Degree (for Directed Graphs)

In directed graphs, adjacency has a direction:

- **In-degree** of a vertex = number of edges pointing **into** it
- **Out-degree** of a vertex = number of edges pointing **out of** it

```
    A → B → C
        ↓
        D
```

- In-degree of `B` = 1 (from `A`)
- Out-degree of `B` = 2 (to `C` and `D`)

---

## Undirected Graphs

In an **undirected graph**, edges have **no direction**. If vertex `A` is connected to vertex `B`, then `B` is equally connected to `A`. Think of a two-way street.

```
    1 --- 2
    |   / |
    |  /  |
    3 --- 4
```

### Properties

- Every edge `(u, v)` implies `(v, u)` — the connection goes both ways
- The degree of a vertex = total number of edges attached to it
- Used to model: friendships, roads, electrical circuits

### Java Implementation (Undirected)

```java
import java.util.*;

public class UndirectedGraph {
    private int vertices;
    private List<List<Integer>> adjList;

    public UndirectedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add an undirected edge between u and v
    public void addEdge(int u, int v) {
        adjList.get(u).add(v); // u → v
        adjList.get(v).add(u); // v → u  (both directions!)
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " → ");
            System.out.println(adjList.get(i));
        }
    }

    public static void main(String[] args) {
        UndirectedGraph g = new UndirectedGraph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.printGraph();
    }
}
```

**Output:**
```
Vertex 0 → [1, 2]
Vertex 1 → [0, 3]
Vertex 2 → [0, 3]
Vertex 3 → [1, 2]
```

Notice how each edge appears **twice** — once from each end. That's the hallmark of an undirected graph.

---

## Directed Graphs (Digraphs)

In a **directed graph** (digraph), every edge has a **specific direction**. An edge `(A → B)` does NOT imply `(B → A)`. Think of a one-way street.

```
    1 → 2
    ↑   ↓
    4 ← 3
```

### Properties

- Edge `(u, v)` means you can go from `u` to `v`, but not necessarily from `v` to `u`
- Each vertex has an **in-degree** and an **out-degree**
- Used to model: web links, task dependencies, Twitter follows, city one-way roads

### Java Implementation (Directed)

```java
import java.util.*;

public class DirectedGraph {
    private int vertices;
    private List<List<Integer>> adjList;

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    // Add a DIRECTED edge from u to v only
    public void addEdge(int u, int v) {
        adjList.get(u).add(v); // Only u → v
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " → ");
            System.out.println(adjList.get(i));
        }
    }

    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(4);
        g.addEdge(0, 1); // 0 → 1
        g.addEdge(0, 2); // 0 → 2
        g.addEdge(1, 3); // 1 → 3
        g.addEdge(2, 3); // 2 → 3
        g.printGraph();
    }
}
```

**Output:**
```
Vertex 0 → [1, 2]
Vertex 1 → [3]
Vertex 2 → [3]
Vertex 3 → []
```

Vertex `3` has no outgoing edges — it's a "sink" node. Unlike the undirected version, edge `(0 → 1)` does NOT create a reverse entry for `1`.

---

## Adjacency Matrix

An **adjacency matrix** is a 2D array of size `V × V` (where `V` = number of vertices).

- `matrix[i][j] = 1` → there is an edge from vertex `i` to vertex `j`
- `matrix[i][j] = 0` → there is NO edge

For **weighted graphs**, store the weight instead of `1`.

### Undirected Adjacency Matrix

Because edges go both ways, the matrix is **symmetric**: `matrix[i][j] == matrix[j][i]`.

```
Graph:
    0 --- 1
    |     |
    2 --- 3

Matrix:
      0  1  2  3
  0 [ 0  1  1  0 ]
  1 [ 1  0  0  1 ]
  2 [ 1  0  0  1 ]
  3 [ 0  1  1  0 ]
```

### Directed Adjacency Matrix

`matrix[i][j] = 1` means edge FROM `i` TO `j`. Not necessarily symmetric.

```
Graph:
    0 → 1
    ↓   ↓
    2   3

Matrix:
      0  1  2  3
  0 [ 0  1  1  0 ]
  1 [ 0  0  0  1 ]
  2 [ 0  0  0  0 ]
  3 [ 0  0  0  0 ]
```

### Java Implementation (Adjacency Matrix)

```java
public class AdjacencyMatrix {
    private int[][] matrix;
    private int vertices;

    public AdjacencyMatrix(int vertices) {
        this.vertices = vertices;
        matrix = new int[vertices][vertices];
    }

    // Undirected: add edge in both directions
    public void addEdgeUndirected(int u, int v) {
        matrix[u][v] = 1;
        matrix[v][u] = 1;
    }

    // Directed: add edge in one direction only
    public void addEdgeDirected(int u, int v) {
        matrix[u][v] = 1;
    }

    // Check if two vertices are adjacent — O(1)!
    public boolean isAdjacent(int u, int v) {
        return matrix[u][v] == 1;
    }

    public void printMatrix() {
        System.out.print("  ");
        for (int i = 0; i < vertices; i++) System.out.print(i + " ");
        System.out.println();
        for (int i = 0; i < vertices; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        AdjacencyMatrix g = new AdjacencyMatrix(4);
        g.addEdgeUndirected(0, 1);
        g.addEdgeUndirected(0, 2);
        g.addEdgeUndirected(1, 3);
        g.addEdgeUndirected(2, 3);

        g.printMatrix();

        System.out.println("Are 0 and 1 adjacent? " + g.isAdjacent(0, 1)); // true
        System.out.println("Are 0 and 3 adjacent? " + g.isAdjacent(0, 3)); // false
    }
}
```

**Output:**
```
  0 1 2 3
0 0 1 1 0
1 1 0 0 1
2 1 0 0 1
3 0 1 1 0
Are 0 and 1 adjacent? true
Are 0 and 3 adjacent? false
```

### Strengths and Weaknesses of Adjacency Matrix

**Strengths:**
- Check if two vertices are adjacent in **O(1)** — just look up `matrix[u][v]`
- Simple and intuitive to implement
- Great for **dense graphs** (many edges)

**Weaknesses:**
- Always uses **O(V²)** space, even if the graph has very few edges
- Iterating over all neighbors of a vertex takes **O(V)** time
- Wastes memory for **sparse graphs** (few edges)

---

## Adjacency List

An **adjacency list** stores a list of neighbors for each vertex. It only stores edges that actually exist.

- Typically implemented as an array (or `ArrayList`) of lists
- `adjList[i]` contains all vertices adjacent to vertex `i`

### Undirected Adjacency List

```
Graph:
    0 --- 1
    |     |
    2 --- 3

Adjacency List:
    0: [1, 2]
    1: [0, 3]
    2: [0, 3]
    3: [1, 2]
```

### Directed Adjacency List

```
Graph:
    0 → 1
    ↓   ↓
    2   3

Adjacency List:
    0: [1, 2]
    1: [3]
    2: []
    3: []
```

### Java Implementation (Adjacency List)

```java
import java.util.*;

public class AdjacencyList {
    private int vertices;
    private List<List<Integer>> adjList;

    public AdjacencyList(int vertices) {
        this.vertices = vertices;
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new LinkedList<>()); // LinkedList for efficient insertions
        }
    }

    // Undirected
    public void addEdgeUndirected(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    // Directed
    public void addEdgeDirected(int u, int v) {
        adjList.get(u).add(v);
    }

    // Get all neighbors of a vertex
    public List<Integer> getNeighbors(int u) {
        return adjList.get(u);
    }

    // Check adjacency — O(degree) time
    public boolean isAdjacent(int u, int v) {
        return adjList.get(u).contains(v);
    }

    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + " → ");
            System.out.println(adjList.get(i));
        }
    }

    public static void main(String[] args) {
        AdjacencyList g = new AdjacencyList(5);
        g.addEdgeUndirected(0, 1);
        g.addEdgeUndirected(0, 4);
        g.addEdgeUndirected(1, 2);
        g.addEdgeUndirected(1, 3);
        g.addEdgeUndirected(1, 4);
        g.addEdgeUndirected(2, 3);
        g.addEdgeUndirected(3, 4);

        g.printGraph();

        System.out.println("Neighbors of vertex 1: " + g.getNeighbors(1));
        System.out.println("Are 0 and 3 adjacent? " + g.isAdjacent(0, 3)); // false
    }
}
```

**Output:**
```
Vertex 0 → [1, 4]
Vertex 1 → [0, 2, 3, 4]
Vertex 2 → [1, 3]
Vertex 3 → [1, 2, 4]
Vertex 4 → [0, 1, 3]
Neighbors of vertex 1: [0, 2, 3, 4]
Are 0 and 3 adjacent? false
```

### Adjacency List with a HashMap (for String Labels)

When vertices are strings instead of integers, use a `HashMap`:

```java
import java.util.*;

public class NamedGraph {
    private Map<String, List<String>> adjList = new HashMap<>();

    public void addVertex(String vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(String u, String v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u); // Remove this line for directed graphs
    }

    public void printGraph() {
        for (Map.Entry<String, List<String>> entry : adjList.entrySet()) {
            System.out.println(entry.getKey() + " → " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        NamedGraph g = new NamedGraph();
        g.addVertex("Alice");
        g.addVertex("Bob");
        g.addVertex("Carol");

        g.addEdge("Alice", "Bob");
        g.addEdge("Bob", "Carol");
        g.addEdge("Alice", "Carol");

        g.printGraph();
    }
}
```

**Output:**
```
Alice → [Bob, Carol]
Bob → [Alice, Carol]
Carol → [Bob, Alice]
```

### Strengths and Weaknesses of Adjacency List

**Strengths:**
- **Space efficient** — uses `O(V + E)` space (only stores real edges)
- Fast neighbor iteration — just loop through the list
- Great for **sparse graphs** (few edges compared to V²)

**Weaknesses:**
- Checking if two vertices are adjacent takes **O(degree)** time — you have to scan the list
- Slightly more complex to implement than a matrix

---

## Comparison: Matrix vs List

| Feature | Adjacency Matrix | Adjacency List |
|--------|-----------------|---------------|
| Space | O(V²) | O(V + E) |
| Check edge (u,v) | **O(1)** | O(degree of u) |
| List all neighbors | O(V) | **O(degree of u)** |
| Add edge | O(1) | O(1) |
| Best for | Dense graphs | Sparse graphs |
| Implementation | Simple 2D array | Array of lists |

### When to Use Which?

**Use an Adjacency Matrix when:**
- You need very fast edge lookups: `isAdjacent(u, v)` in O(1)
- The graph is dense (many edges — close to V² edges)
- The graph is small (V is not too large, so V² memory is acceptable)

**Use an Adjacency List when:**
- The graph is sparse (few edges relative to vertices)
- You frequently need to iterate over neighbors
- Memory efficiency is a concern
- Most real-world graphs (social networks, maps, web graphs) are sparse, so this is usually the right default

---

## Summary

Here is a high-level recap of everything covered:

- A **graph** consists of vertices (nodes) and edges (connections).
- **Adjacency** means two vertices are directly connected by a single edge.
- An **undirected graph** has two-way edges — if A connects to B, then B connects to A.
- A **directed graph** has one-way edges — A → B does not imply B → A.
- An **adjacency matrix** is a V×V grid: fast edge lookups (O(1)), but uses O(V²) space.
- An **adjacency list** stores lists of neighbors: space efficient (O(V+E)), great for sparse graphs.

```
Quick Decision Tree:

Is your graph dense (many edges)?
    YES → Adjacency Matrix
    NO  → Adjacency List (default choice for most problems)

Do you need O(1) edge lookup?
    YES → Adjacency Matrix
    NO  → Adjacency List
```

With these two representations and an understanding of directed vs. undirected graphs, you now have the foundation to implement graph algorithms like BFS, DFS, Dijkstra's, and more in Java.
