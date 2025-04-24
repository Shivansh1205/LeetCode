class MyLinkedList {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    Node head;
    int size;
    public MyLinkedList() {
        head  = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index>=size || index<0){
            return -1;
        }
        Node temp = head;
        for(int i =0; i<index; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node temp = new Node(val);
        temp.next = head;
        head = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        Node temp = new Node(val);
        if(head==null){
            head = temp;
        }else{
            Node cur = head;
            while(cur.next!=null) cur = cur.next;
            cur.next = temp;
            
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
    if (index > size) return;
    if (index <= 0) {
        addAtHead(val);
    } else if (index == size) {
        addAtTail(val);
    } else {
        Node cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        Node temp = new Node(val);
        temp.next = cur.next;
        cur.next = temp;
        size++;
    }
}
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */