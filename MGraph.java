public class MGraph<K extends Comparable<K>> implements Graph<K> {
   public Map<K, List<K>> adj; // Do not change this
   public MGraph() {
      adj=new BSTMap<K, List<K>>(); 
   }
		// Add a node to the graph if it does not exist and return true. If the node already exists, return false.
   public boolean addNode(K i){
      if(adj.retrieve(i).first==true)
         return false;
      List<K> neighbors =new LinkedList<K>(); 
      adj.insert(i,neighbors);
      return true;
   }
 
	// Check if i is a node
   public boolean isNode(K i){
      if(adj.retrieve(i).first==true)
         return true;
      return false;
   }
   
 // Add an edge to the graph if it does not exist and return true. If i or j do not exist or the edge (i, j) already exists, return false.
   public boolean addEdge(K i, K j){
   //first check :
      if(!isNode(i)||!isNode(j)) 
         return false;
   //second check :
      List<K> yasmeen = adj.retrieve(i).second;
      if(yasmeen.exists(j)) 
         return false;
      yasmeen=adj.retrieve(j).second;
      if(yasmeen.exists(i)) 
         return false;
   //-----------------------------
      yasmeen.insert(i);
      adj.retrieve(i).second.insert(j);
       
      return true;
   }

	// Check if (i, j) is an edge.
   public boolean isEdge(K i, K j){
   
      if(!isNode(i)||!isNode(j)) 
         return false;
      List<K> yasmeen = adj.retrieve(i).second;
      if(!yasmeen.exists(j)) 
         return false;
      yasmeen=adj.retrieve(j).second;
      if(!yasmeen.exists(i)) 
         return false;
      return true;
   }


	// Return the set of neighbors of node i. If i does not exist, the method returns null.
   public List<K> neighb(K i){
      if(!isNode(i)) 
         return null;
      List<K> yasmeen = adj.retrieve(i).second;
      return yasmeen;
   }


	// Return the degree (the number of neighbors) of node i. If i does not exist, the method returns -1.
   public int deg(K i){
      if(!isNode(i)) 
         return -1;
      List<K> yasmeen = adj.retrieve(i).second;
      int degree= yasmeen.size();
      return degree;
   }

	// Return a list containing the nodes in increasing order.
   public List<K> getNodes(){
      List<K> yasmeen=adj.getKeys();
      return yasmeen;
   }







}
  
   
   
   
   
   
   
   
   

