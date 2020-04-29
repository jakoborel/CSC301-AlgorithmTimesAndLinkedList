public class SinglyLinkedList<T>
{
    private ListNode<T> head;
    private ListNode<T> tail;
    private int nodeCount;

    public SinglyLinkedList(){
        head = null;
        tail = null;
        nodeCount = 0;
    }

    public int size(){
        return nodeCount;
    }

    private boolean isEmpty(){
        return nodeCount == 0;
    }

    public void addFirst(T data){
        ListNode<T> newNode = new ListNode<T>(data);

        if(this.isEmpty())
            tail = newNode;
        else
            newNode.setNext(head);

        head = newNode;
        nodeCount++;
    }

    public void addLast(T data){
        ListNode<T> newNode = new ListNode<T>(data);

        if(this.isEmpty()){
            head = newNode;
        }
        else{  
            tail.setNext(newNode);
        }

        tail = newNode;
        nodeCount++;
    }

    private ListNode<T> search(T key){
        ListNode<T> temp = head;

        while(temp!=null){
            if(temp.getNodeData().equals(key))
                return temp;
            temp = temp.getNext();
        }

        return null;
    }

    public void removeFirst() throws Exception{
        if(this.isEmpty())
            throw new Exception("ERROR: LIST IS EMPTY");

        if(nodeCount == 1){
            head = null;
            tail = null;
        }
        else
            head = head.getNext();

        nodeCount--;
    }

    public void removeLast() throws Exception{
        if(this.isEmpty())
            throw new Exception("ERROR: LIST IS EMPTY");

        if(nodeCount == 1){
            head = null;
            tail = null;
        }
        else{
            ListNode<T> temp = head;

            for(int i = 0; i < nodeCount - 1; i++)
                temp = temp.getNext();

            temp.setNext(null);
            tail = temp;
        }

        nodeCount--;
    }

    public void remove(T key) throws Exception{
        ListNode<T> node = this.search(key);

        if(node.equals(null)){
            throw new Exception("ERROR: KEY IS NOT IN LIST");
        }
        else if(node.equals(head)){
            this.removeFirst();
        }
        else if(node.equals(tail)){
            this.removeLast();
        }
        else{
            ListNode<T> temp = head;
            while(!(temp.getNext().equals(node)))
                temp = temp.getNext();

            temp.setNext(node.getNext());
            nodeCount--;
        }
    }

    public boolean contain(T item){
        return this.search(item) != null;
    }

    public void insert(T item, int pos) throws Exception{
        if(pos < 0 || pos > nodeCount)
            throw new Exception("ERROR: INVALID POSITION");

        if(pos == 0)
            this.addFirst(item);
        else if(pos == nodeCount)
            this.addLast(item);
        else{
            ListNode<T> node = new ListNode(item);
            ListNode<T> temp = head;
            for(int i = 0; i < pos - 1; i++)
                temp = temp.getNext();

            node.setNext(temp.getNext());
            temp.setNext(node);
            nodeCount++;
        }
    }

    private void printList(){
        //prints the node# and then data value
        ListNode<T> temp = head;
        for(int i = 0; i < nodeCount; i++){
            System.out.println("| " + i +" | "+ temp.getNodeData()+ " |");
            temp = temp.getNext();
        }
    }

    public static void main(String[] args){
        //testing
        try{
            SinglyLinkedList<Integer> numList = new SinglyLinkedList<Integer>(); 

            numList.addFirst(5);
            numList.addFirst(4);
            numList.addFirst(10);

            numList.addLast(30);
            numList.addLast(24);

            numList.printList();

            System.out.println("---------------------");

            numList.insert(9, 3);

            numList.printList();

            System.out.println("---------------------");

            numList.removeLast();

            numList.printList();            

            System.out.println("---------------------");
            
            numList.removeFirst();
            
            numList.printList();
            
            System.out.println("---------------------");
            
            numList.remove(10);
            
            numList.printList();
        }
        catch(Exception e){
            System.out.println();
        }
    }
}
