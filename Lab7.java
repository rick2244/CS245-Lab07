package CS245_Lab07;

public class Lab7 {
    /**
     * Definition of a LinkedList*
     */
    public static class LLN {
        int val;
        LLN next;

        LLN() {
        }

        LLN(int val) {
            this.val = val;
        }

        LLN(int val, LLN next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * head of the LinkedList*
     */
    private LLN head;

    /**
     * Initialize a new head*
     */
    public Lab7() {
        head = new LLN();
    }

    /**
     * Helper function to quickly add a new node to the end of the list*
     *
     * @param value new node's value
     */
    public void add(int value) {
        LLN node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new LLN(value);
    }

    /**
     * Print out the head LinkedList*
     */
    private void print() {
        print(head);
    }

    /**
     * Helper function to print out given LinkedList*
     *
     * @param node given node containing the LinkedList info
     */
    public void print(LLN node) {
        StringBuilder result = new StringBuilder();
        LLN temp = node;
        while (temp != null) {
            result.append(temp.val).append("->");
            temp = temp.next;
        }
        result.append("NULL");
        System.out.println(result);
    }
    public int size(LLN head) {
    	LLN temp = head;
    	int count = 0;
    	while(temp != null) {
    		count++;
    		temp = temp.next;
    	}
    	return count;
    }
    /**
     * Calls the public version of listOps(LLN head, int[] operations) function*
     *
     * @param operations array of operations number
     * @return the LinkedList after performed given ops
     */
    private LLN listOps(int[] operations) {
        return listOps(head, operations);
    }

    /**
     * TODO *
     *
     * @param head
     * @param operations
     * @return
     */
    public LLN listOps(LLN head, int[] operations) {
    	LLN node = head.next;
    	//If conditional handles if the operation is {2} and it prints out the right
    	//node if that is it
    	if(operations.length == 1 && operations[0] == 2) {
    		node = opsZero(node);
    		//For loop walks the linked lists to the start of the second half of the linked list 
			//This conditional handles when the linked list is odd
    		if(size(node)%2 == 1) {
				for(int i = 0; i < size(head)/2-1;i++) {
	    			node = node.next;
	    		}
			}//This conditional handles when the linked list is even
			else if(size(node)%2 == 0) {
				for(int i = 0; i < size(head)/2;i++) {
	    			node = node.next;
	    		}
			}
			//returns the second half of the linked list
    		return node;
    	}
    	//This else conditional handles every other situation  in which the operation isn't {2}
    	else {
    		for(int i = 0; i < operations.length; i++){
            	if(operations[i] == 0) {
            		node = opsZero(node);
            	}
            	else if(operations[i] == 1) {
            		node = opsOne(node);
            	}
            	else if(operations[i] == 2) {
            		node = opsTwo(node);
            	}
            	
            }
    		//returns the full node starting with 1
            return node;
    	}
        
    }

    /**
     * TODO*
     *
     * @param head
     * @return
     */
    public LLN opsZero(LLN head) {
    	int length = size(head);
    	LLN temp = head;
    	LLN second_half = null;
    	//These two if conditionals handle whether the linked list is even or odd and finds the right
    	//middle node based on those conditionals
    	//First finds if the linked list is odd
    	if(length%2 == 0) {
    		for(int i = 0; i < length; i++) {
    			if(i == length/2) {
    				second_half = temp;
    			}
    			temp = temp.next;
    		}
       	}//Second conditional handles if the linked list is even
    	else if(length%2 == 1) {
    		for(int i = 0; i < length; i++) {
    			if(i == length/2) {
    				second_half = temp;
    			}
    			temp = temp.next;
    		}
    	}
    	//prints out the middle node
        System.out.println("\"" + second_half.val + "\"");
        //printTrue(second_half);
        return head;
    }

    /**
     * TODO*
     *
     * @param head
     * @return
     */
    public LLN opsOne(LLN head) {
    	LLN prev, curr, next;
    	prev = null;
    	curr = head;
    	next = null;
    	//While loop adds the values of head to prev in reverse order
    	while(curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	//sets head to prev
    	head = prev;
    	//returns reversed oder of linked list
    	return head;
    }

    /**
     * TODO*
     *
     * @param head
     * @return
     */
    public LLN opsTwo(LLN head) {
        LLN first_half, curr,next, prev;
        first_half = null;
        curr = head;
        next = null;
        prev = null;
        
        int len = size(head);
        //The first for loop handles the finding the first half of the linked list
    	for(int i = 0; i < len/2; i++) {
    		first_half = curr;
    		curr = curr.next;
    	}
    	//This for loop reverse the second half of the linked list
    	while(curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	//Links the two linked list halfs together
        first_half.next = prev;
        return head;

    }
    //This is my own print statement that prints out the values of the linked list in
    //the desired format of the lab requirements
    public void printTrue(LLN head) {
    	LLN walk = head;
    	System.out.print("[");
    	while(walk != null) {
    		if(walk.next != null) {
    			System.out.print(walk.val + ",");
    		}
    		else if(walk.val != 0){
    			System.out.print(walk.val);
    		}
    		walk = walk.next;
    	}
    	System.out.print("]");
    		
    }

    public static void main(String[] args) {
        Lab7 lln = new Lab7();
        lln.add(1);
        lln.add(2);
        lln.add(3);
        lln.add(4);
        lln.add(5);
        lln.add(6);
        //lln.add(7);
        //lln.add(8);
        //lln.print();// 0->1->2->3->4->5->NULL

        
        LLN ret;
        ret = lln.listOps(new int[] {2,1,2,1,2});
        //lln.print(ret);//5->4->3->2->1->0->NULL
        lln.printTrue(ret);
        

    }
}
