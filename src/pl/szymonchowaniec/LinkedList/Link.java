package pl.szymonchowaniec.LinkedList;

public class Link {

    public String bookName;
    public int millionsSold;

    public Link next;


    public Link (String bookName, int millionsSold) {
        this.bookName = bookName;
        this.millionsSold = millionsSold;
    }

    public void display(){
        System.out.println(bookName+": "+millionsSold+",000,000");
    }

    @Override
    public String toString() {
        return bookName;
    }
}

class LinkList{

    public Link firstLink;

    LinkList(){
        firstLink = null;
    }

    public boolean isEmpty(){
        return firstLink==null;
    }

    public void insertFirstLink(String bookName, int millionsSold){
        Link newLink = new Link(bookName,millionsSold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public Link removeFirst(){
        Link linkReferance = firstLink;

        if(!isEmpty()){
            firstLink = firstLink.next;
        }
        else {
            System.out.println("Empty LinkedList.");
        }
        return linkReferance;
    }

    public void display(){
        Link theLink = firstLink;
        while (theLink != null){
            theLink.display();

            System.out.println("Next Link: "+ theLink.next);

            theLink = theLink.next;
            System.out.println();

        }
    }

    public Link find(String bookName){
        Link theLinkToFind = firstLink;
        if(!isEmpty()) {
            while (theLinkToFind.bookName != bookName ) {
                if (theLinkToFind.next == null) {
                    return null;
                } else {
                    theLinkToFind = theLinkToFind.next;
                }

            }
        }
        else{
            System.out.println("LinkedList is Empty.");
        }
        return theLinkToFind;
    }

    public Link removeLink(String bookName){
        Link currentLink = firstLink;
        Link previousLink = firstLink;

        if(!isEmpty()){

            while(!currentLink.bookName.equals(bookName)){
                if(currentLink.next == null){
                    System.out.println("No book with this name.");
                    return null;
                }
                else {
                    previousLink = currentLink;
                    currentLink = currentLink.next;
                }
            }

        }
        else{
            System.out.println("EmptyLinked List.");
        }

        if (currentLink == firstLink){
            firstLink = firstLink.next;
        }
        else {
            previousLink.next = currentLink.next;
        }
        return currentLink;
    }

    public static void main(String[] args) {
        LinkList theLinkedList = new LinkList();
        theLinkedList.insertFirstLink("Ania z Zielonego wzgóża.", 100);
        theLinkedList.insertFirstLink("Ania z Czerwonego wzgóża.", 200);
        theLinkedList.insertFirstLink("Ania z Czarnego wzgóża.", 300);
        theLinkedList.insertFirstLink("Ania z Niebieskiego wzgóża.", 400);
       // theLinkedList.removeFirst();
        theLinkedList.display();

        System.out.println(theLinkedList.find("Ania z Niebieskiego wzgóża.").bookName+" -  was found");
        theLinkedList.removeLink("Ania z Niebieskiego wzgóża.");
        theLinkedList.display();
    }
}
