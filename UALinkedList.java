/***********************************
Due Date:		March 12th, 2020
***********************************/

import java.io.*;

public class UALinkedList {
	
	UACourse head = null;
	UACourse tail = null;
	int size = 0;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		String line;
		String file = "records.txt";
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		UALinkedList list = new UALinkedList();
		
		while ( (line = br.readLine()) != null) {
			
			String[] tokens = line.split( "," );
			
			list.insert(new UACourse((Integer.parseInt(tokens[2])), tokens[0], tokens[1]));
			
		}
		
		br.close();
		
		list.printList();
		list.printListReversed(list.head);
		
		list.find(12345);
		list.find(45678);
		
		list.insert(new UACourse(44332, "GPU Programming", "A fun course"));
		
		list.find(12345);
		
		//list.remove(45678);
		
		list.find(55555);
		
		list.insert(new UACourse(44432, "Natural Language Processing", "NLP class"));
		
		list.find(44432);
		
		list.printList();		
		
	}
	
	public UACourse find( int courseId ) {
		UACourse c = head;

		if(head == null) {
			System.out.println("No courses have been entered."); 
			return null;
		} else {
			while(c != null) {
				if(c.getCourseId() == courseId) {
					int current = c.getAccessCount();
					int count = 1;
					c.setAccessCount(current + count);
					return c;
				} else {
					c = c.next;
				}
			}
			
			if(c.getAccessCount() < c.next.getAccessCount()) {
				UACourse predecessor = c.prev;
				UACourse successor = c.next;
				predecessor.next = successor;
				successor = predecessor;
			}
			return null;
		}
	}
	
	public void insert( UACourse s ) {
		if(head == null) {
			head = s;
			tail = s;
		} else if(s.getCourseId() == head.getCourseId()) {
				System.out.println("ERROR - INVALID ID");
		} else {
			s.next = head;
			head.prev = s;
			head = s;
			tail = s;
			size++;
		}
	}
	
	public void remove( UACourse c ) {
		if(head == null) {
			return;
		} else {
			UACourse a = head;
			while (a.next != c) {
				a = a.next;
			}
			a.next = c.next;
			size--;
		}
		
	}
	
	public void remove( int i ) {
		UACourse c = head;
		if(head == null) {
			return;
		} else {
			while(c != null) {
				if(c.getCourseId() != i) {
					c = c.next;
				} else {
					UACourse predecessor = c.prev;
					UACourse successor = c.next;
					predecessor.next = successor;
					successor = predecessor;
					
					size--;
				}
			}
		}
		
	}
	
	public void printList() {
		UACourse c = head;  
        
        while(c != null) {  
            System.out.printf(c.toString());  

            c = c.next;
        }  
    }  
	
	public void printListReversed(UACourse head) {
		
			if (head == null) {
				return;
			} else {
				printListReversed(head.next);
				System.out.printf(head.toString());
			}
	}

}
