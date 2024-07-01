class LinkedL{
    Node headNode;
    LinkedL(Node head){
        this.headNode=head;
    }
    public void insertAtTail(int data)
    {
        Node n= new Node(data,null);
        Node curr = new Node();
        curr=headNode;
        while(curr.next!=null)
        {
            curr=curr.next;
        }
        curr.next=n;
    }
    public void printH(){
        Node curr = new Node();
        curr=headNode;
        while(curr!=null)
        {
            System.out.println(curr.value);
            curr=curr.next;
        }
    }
    public void insert(int index,int data){
        Node n= new Node(data,null);

        if(index==0)
        {
            n.next=headNode;
            headNode=n;
            return;
        }
        Node curr = new Node();
        int count=0;
        curr=headNode;
        while(curr.next!=null && count<index)
        {
            curr=curr.next;
            count++;
        }
        Node temp=new Node();
       temp= curr.next;
        curr.next  = n;
        n.next=temp;
    }
    public void remove(int index){
        if(index==0)
        {
            headNode=headNode.next;
            return;
        }
        Node curr = new Node();
        int count=0;
        curr=headNode;
        while(curr.next!=null && count<index)
        {
            curr=curr.next;
            count++;
        }
        Node temp=new Node();
        if(curr.next.next!=null)
        {temp= curr.next.next;
        curr.next  =temp;}
       
    }
}