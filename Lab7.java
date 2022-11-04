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
    	return count-1;
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
        return node;
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
    	if(length%2 == 0) {
    		for(int i = 0; i < length; i++) {
    			if(i == length/2) {
    				second_half = temp;
    			}
    			temp = temp.next;
    		}
       	}
    	else if(length%2 == 1) {
    		for(int i = 0; i < length; i++) {
    			if(i == length/2+1) {
    				second_half = temp;
    			}
    			temp = temp.next;
    		}
    	}
        System.out.println(second_half.val);
        //printTrue(second_half);
        return head; //TODO complete this function, remove this line when you start
    }

    /**
     * TODO*
     *
     * @param head
     * @return
     */
    public LLN opsOne(LLN head) {
        //TODO complete this function, remove this line when you start
    	LLN prev, curr, next;
    	prev = null;
    	curr = head;
    	next = null;
    	while(curr != null) {
    		next = curr.next;
    		curr.next = prev;
    		prev = curr;
    		curr = next;
    	}
    	head = prev;
    	return head;
    }

    /**
     * TODO*
     *
     * @param head
     * @return
     */
    public LLN opsTwo(LLN head) {
        //TODO complete this function, remove this line when you start
        LLN first_half, curr,next, prev;
        first_half = null;
        curr = head;
        next = null;
        prev = null;
        
        int len = size(head);
        
        if(len%2 == 0) {
        	for(int i = 0; i < len/2; i++) {
        		first_half = curr;
        		curr = curr.next;
        	}
        	
        	while(curr != null) {
        		next = curr.next;
        		curr.next = prev;
        		prev = curr;
        		curr = next;
        	}
        }
        else if(len%2 == 1) {
        	for(int i = 0; i < len/2+1; i++) {
        		first_half = curr;
        		curr = curr.next;
        	}
        	while(curr != null) {
        		next = curr.next;
        		curr.next = prev;
        		prev = curr;
        		curr = next;
        	}
        }
        first_half.next = prev;
        return head;

    }
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
        lln.add(11);
        lln.add(2);
        lln.add(-4);
        lln.add(5);
        lln.add(1);
        //lln.add(6);
        lln.print();// 0->1->2->3->4->5->NULL

        //Reverse whole list
        LLN ret;
        ret = lln.listOps(new int[] {2,1,2,1});
        //lln.print(ret);//5->4->3->2->1->0->NULL
        lln.printTrue(ret);
        //Test your code here
        //......

    }
}
