public class ListNode<T>{
    private T data;
    private ListNode<T> next;
    
    public ListNode(T data){
        this.data = data;
        next = null;
    }
    
    public T getNodeData(){
        return data;
    }
    
    public ListNode<T> getNext(){
        return next;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public void setNext(ListNode<T> next){
        this.next = next;
    }
}
