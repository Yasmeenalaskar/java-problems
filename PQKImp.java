public class PQKImp<P extends Comparable<P>, T> implements PQK<P, T> {
   private int size;
   private PQNode<P,T> head, tail;
   private int nf;

   public PQKImp(int k) {
      nf=k;
      size=0;
      head = tail = null;
   }
   
   public int length(){
      return size;
   }

	// Enqueue a new element. The queue keeps the k elements with the highest priority. In case of a tie apply FIFO.
   public void enqueue(P pr, T e){
   
      PQNode<P,T> yasmeen =new PQNode<P,T>(pr,e); 
      if(size<nf){
         if(size==0||head==null||pr.compareTo(head.priority)>0){
            yasmeen.next=head;
            if(head==null)
               tail=head=yasmeen;
            else
               head=yasmeen;
         
            size++;
            return ;
         }
         else{
            PQNode<P,T>p=head; 
            PQNode<P,T>q=null; 
         
            while(p!=null) 
            { 
               if((pr.compareTo(p.priority)) > 0)
                  break;
               q=p;   
               p=p.next; 
            } 
            q.next=yasmeen; 
            yasmeen.next=p; 
            if(p==null) 
               tail=yasmeen; 
            size++;
         }
            
      } else
      
         great(pr,e);}
    
    
   private void great(P pr, T e){
      PQNode<P,T> yasmeen =new PQNode<P,T>(pr,e); 
   
      if(pr.compareTo(head.priority)>0){
         yasmeen.next=head;
         head=yasmeen;
      }
      else{
         PQNode<P,T>p=head; 
         PQNode<P,T>q=null; 
         while(p!=null) 
         { 
            if((pr.compareTo(p.priority)) > 0)
               break;
            q=p;   
            p=p.next; 
         } 
      
         q.next=yasmeen; 
         yasmeen.next=p; 
         if(p==null) 
            tail=yasmeen; }
      PQNode<P,T>y=head; 
      if(y==null||y==tail) 
         return; 
      while(y.next!=tail) 
         y=y.next;  
      tail=y; 
      y.next=null;
   
   
      
      
   }
 

   public Pair<P, T> serve(){
      Pair<P, T> x = new Pair<P, T>(null,null);
      if(head==null||size==0) 
         return x;
      P py =head.priority;
      T d=head.data;
      head=head.next;
      if(head==null)
         tail=null;
      size--;
      return new Pair<P, T>(py,d);
   }





}























   
   
   
   


