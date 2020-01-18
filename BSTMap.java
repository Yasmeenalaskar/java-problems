public class BSTMap<K extends Comparable<K>, T> implements Map<K, T> {
   private int msize;
   public BSTNode<K, T> root; // Do not change this
   public BSTMap() {
      msize=0;
      root=null;
   }
         
	// Return the size of the map.         
   public int size(){
      return msize;
   }      
         
// Return true if the map is full.
   public boolean full(){
      return false;
   }        
         
// Remove all elements from the map.
   public void clear(){
   
      root=null;
      msize=0;
   }         
         
  	// Update the data of the key k if it exists and return true. If k does not exist, the method returns false.
   public boolean update(K k, T e){
      if(root==null)
         return false;
      BSTNode<K, T> y=root;
   
      while(y!=null) {
         if(y.key.compareTo(k)==0){
            y.data=e;
            return true;}
         else if(y.key.compareTo(k)<0)
            y=y.right;
         else
            y=y.left;
      }
      return false;
   
   }    
	// Search for element with key k and returns a pair containing true and its data if it exists. If k does not exist, the method returns false and null.
   public Pair<Boolean, T> retrieve(K k){
   //Pair<P, T> yasmeen=new Pair<P, T>(false,null);
      if(root==null)
         return new Pair<Boolean, T>(false,null);
      BSTNode<K, T> y=root;
      while(y!=null) {
      //if(y.key.compareTo(k)==0){
      //yasmeen.first=true;
      //yasmeen.second=y.data;
      //return yasmeen;
      //return new Pair<Boolean, T>(true,y.data);}
      /*else
      if(y.key.compareTo(k)<0)
      y=y.left;
      else
      y=y.right;
      }
      //return yasmeen;
      return new Pair<Boolean, T>(false,null);*/
         if (y.key.compareTo(k)<0) 
            y = y.right; 
         
         else if (y.key.compareTo(k)>0) 
            y = y.left; 
         else{ // if the key is found  
            return new Pair<Boolean, T>(true,y.data);}
      } 
      return new Pair<Boolean, T>(false,null);
   
   }


 	// Insert a new element if does not exist and return true. If k already exists, return false.
   public boolean insert(K k, T e){
      if(retrieve(k).first==true)
         return false;
      if(root==null){
         root =new BSTNode<K, T>(k,e);
         msize++;
         return true;
      }
   
      BSTNode<K, T> a=root;
      BSTNode<K, T> b=null;
   
      while(a!=null) {
         b=a;
         if(a.key.compareTo(k)==0){
            return false;}
         else if(a.key.compareTo(k)<0)
            a=a.right;
         else
            a=a.left;
      }
      if(b.key.compareTo(k)<0)
         b.right=new BSTNode<K, T>(k,e);
      else
         b.left=new BSTNode<K, T>(k,e);
      msize++;
      return true;
   } 

// Remove the element with key k if it exists and return true. If the element does not exist return false.
   public boolean remove(K k){
   if(retrieve(k).first==false)
         return false;
      else{
         Boolean removed = new Boolean(false);
         BSTNode<K, T> p;
         p = remove_aux(k, root, removed);
            msize--;
         return true ;
      }
   }
   private BSTNode<K, T> remove_aux(K k,BSTNode<K, T> p, Boolean flag) {
   
      BSTNode<K, T> q, child = null;
      if(p == null)
         return null;
      if(k.compareTo(p.key)<0)
         p.left = remove_aux(k, p.left, flag); //go left
      else if(k.compareTo(p.key)>0)
         p.right = remove_aux(k, p.right, flag); //go right
      else {
         flag= true;
         if (p.left != null && p.right != null){ //two children
            q = find_min(p.right);
            p.key = q.key;
            p.data = q.data;
            p.right = remove_aux(q.key, p.right, flag);
         }
         else {
            if (p.right == null) //one child
               child = p.left;
            else if (p.left == null) //one child
               child = p.right;
            return child;
         }
      }
      return p;
   }
   private BSTNode<K, T> find_min(BSTNode<K, T> p){
      if(p == null)
         return null;
   	
      while(p.left != null){
         p = p.left;
      }
   	
      return p;
   }
   //    if(root==null) 
//          return false;
//       if(retrieve(k).first==false) 
//          return false;
//       BSTNode<K, T> a=root;
//       BSTNode<K, T> b=null;
//    
//       while(a!=null) {
//          if(a.key.compareTo(k)==0){
//          //case 1 : no children
//             if(a.right==null&&a.left==null){
//                a=a.right;
//                return true;}
//             b=a;
//          //case 2 :one child
//             if(a.left==null&&a.right!=null){
//                b.right=a.right;
//                a=a.left;
//                return true;
//             }
//             if(a.left!=null&&a.right==null){
//                b.left=a.left;
//                a=a.right;
//                return true;}
//          
//          //case 3 two children 
//             if(a.left!=null && a.right!=null){
//                BSTNode<K, T> y=a;
//                y=y.right;
//                while(y.left!=null){
//                   b=y;
//                   y=y.left;}
//                a.key=y.key;
//                a.data=y.data;
//                a=y;
//             }//case 3
//             msize--;
//             return true;
//          }
//          else if(a.key.compareTo(k)<0){
//             b=a;
//             a=a.left;}
//          else{
//             b=a;
//             a=a.right;}
//       }
//       return false;
//    
//    }














 
	// Return the list of keys in increasing order.
   public List<K> getKeys(){
      BSTNode<K, T> A=root;
      List<K>yasmeen=new LinkedList<K>();
      getKeys(A,yasmeen);
      return yasmeen;
   }
   private void getKeys(BSTNode<K, T> curr,List<K> y){
      if(curr==null)
         return;
      getKeys(curr.left,y);
      y.insert(curr.key);
      getKeys(curr.right,y);
   }





    
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
}//end class
