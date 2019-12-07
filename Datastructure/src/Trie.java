class trie{
    node root = new node();     
    
    public void insert(String word){                    //Iterative insert
        node curr = root;
        node n = null;
        for(int i=0;i<word.length();i++){                 //going through the word character by character
               if(!curr.m.containsKey(word.charAt(i))){   // checking if the curr node contains the character or not
                    n = new node();                       //if not inserting the current character into the curr node and moving on
                   curr.m.put(word.charAt(i),n);
               }
            curr = curr.m.get(word.charAt(i));      // if already present then move to the next level
        }
        curr.isEnd = true;      // once the word is inserted set the end of the word as true;
    }
    
    public void r_insert(String word,int index,node curr){        //Recursive insert Same as Iterative version
        if(index == word.length()){     //checking if we reached the end of the word
            curr.isEnd=true;            // if so set the isEnd to true and return
            return;
        }         
        node n = null;
        if(!curr.m.containsKey(word.charAt(index))){    // else check for the character in the current node 
            n = new node();                             // if not present insert and move to the next character to be inserted
            curr.m.put(word.charAt(index),n);
        }
        r_insert(word,index+1,curr.m.get(word.charAt(index)));  // if already present move to the next level
    }
    
    public boolean search(String word){                   //Iterative search
        node curr = root;
        for(int i=0;i<word.length();i++){             //going through each character and return false if any character is not found
            if(!curr.m.containsKey(word.charAt(i))){
                 return false;
            }
            curr = curr.m.get(word.charAt(i));    // else keep moving through each character
        }
        return curr.isEnd;     // once i reaches the lengthof the word check if it is the end
                              // because if we were to return true here
                              // this case would fail: inserting abcd and seraching abc
                              // it would say abc is present as it has the same prefix as abcd but abc is not at all present
        
        
    }
    
    public boolean r_search(String word,int index,node curr){       //recursive search Same as Iterative version
        if(index == word.length()){
            return curr.isEnd;
        }
        if(!curr.m.containsKey(word.charAt(index)))return false;
        return r_search(word,index+1,curr.m.get(word.charAt(index)));
    }
    
    
    public boolean r_delete(String word,int index,node curr){         // recursive delete
        if(index == word.length()){                             // once we reach the length of the word
            if(!curr.isEnd)return false;                  // if it is the end of the word it is present and continue else we would return false telling the word  to be deleted is not present
            curr.isEnd = false;       // if it is present we make isEnd as false;
            return curr.m.size() == 0;  // and return true or false depending on if the curr node has children or not
        }
        if(!curr.m.containsKey(word.charAt(index)))return false;  //not present return false;
        
        boolean isEmpty = r_delete(word,index+1,curr.m.get(word.charAt(index))); // this is where the returned value comes
                                                                  // can we delete the current node or not
        if(isEmpty){                    // if the current node has no reference then we know we can delete it
            curr.m.remove(word.charAt(index));
            return curr.m.size() == 0;
        }
        return false;              // if it has a reference then we know it has other children so return false to stop removing the reference
        
    }
    
}

class node{
    boolean isEnd;
    HashMap<Character,node>m;
    public node(){
        isEnd= false;
        m = new HashMap<>();
    }
    
}
