import java.io.File;
import java.util.Scanner;

public class Recommender {

	// Return the top k recommended friends for user i using the popular nodes method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
   public static <K extends Comparable<K>> PQK<Double, K> recommendPop(Graph<K> g, K i, int k) {
     
   
      PQK<Double, K> yasmeen = new PQKImp<Double, K>(k);//?
      if(!g.isNode(i))
         return null;
      List<K> keys = g.getNodes();
      if(keys.size()==0||keys.empty()||keys==null) 
         return null;
      keys.findFirst();
      for(int s=0;s<keys.size();s++){
         K elem=keys.retrieve();
         if(elem.compareTo(i)!=0){
            if(!g.isEdge(i,elem)){
               double dg=((double)(g.deg(elem)));
               yasmeen.enqueue(dg,elem);}}
         keys.findNext();      
      }
      return yasmeen;
   }
      
      
   
      
      

	// Return the top k recommended friends for user i using common neighbors method. If i does not exist, return null. In case of a tie, users with the lowest id are selected.
   public static <K extends Comparable<K>> PQK<Double, K> recommendCN(Graph<K> g, K i, int k) {
      PQK<Double, K> yasmeen = new PQKImp<Double, K>(k);      
      int common=0;
      K yes ,elem;
      List<K> neighbors,keys,elemNeighbors ;
      if(!g.isNode(i))
         return null;
      keys = g.getNodes();
      if(keys.size()==0||keys.empty()||keys==null) 
         return null;
      neighbors=g.neighb(i);
      if(neighbors.size()==0||neighbors.empty()||neighbors==null) 
         return null;
      keys.findFirst();
      neighbors.findFirst();
      int size=keys.size();
      for(int s=0;s<size;s++){
         elem=keys.retrieve();
         if(g.isEdge(i,elem)||elem.compareTo(i)==0){
            keys.remove();
            continue;}
         elemNeighbors=g.neighb(elem);
         elemNeighbors.findFirst();
         if(!g.isEdge(i,elem)){
         //if(elemNeighbors==null||neighbors.size()==0||neighbors.empty()) common=0;
            for(int m=0;m<elemNeighbors.size();m++)
            {
               yes =elemNeighbors.retrieve();
               if(neighbors.exists(yes))
                  common++; 
               elemNeighbors.findNext(); }}
          
         
            double dg=((double)common); 
         
            yasmeen.enqueue(dg,elem);
         common=0;
         keys.findNext();}
      
      
      return yasmeen;
      
      
      
      
      
   }
     
       
      
      
      
      
      
      
      
      
	

	// Read graph from file. The file is a text file where each line contains an edge. The end and start of the edge are separated by space(s) or tabs.
   public static Graph<Integer> read(String fileName) {
   
      try {
         Graph<Integer> g = new MGraph<Integer>();
         Scanner scanner = new Scanner(new File("graph.txt"));
         while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            g.addNode(i);
            int j = scanner.nextInt();
            g.addNode(j);
            g.addEdge(i, j);
         }
         scanner.close();
         return g;
      } catch (Exception e) {
         e.printStackTrace();
         return null;
      }
   }
}
