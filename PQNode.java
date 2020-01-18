public class PQNode<P extends Comparable<P>, T>{
	public T data;
	public P priority;
	public PQNode<P,T>next; 
 
	public PQNode(){
   next=null;
   }

	
	public PQNode(P prr, T ee) {
		data = ee;
		priority = prr;
      
	}

	// Setters/Getters?
}
