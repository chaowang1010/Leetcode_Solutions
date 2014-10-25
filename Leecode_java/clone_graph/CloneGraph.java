// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


// OJ's undirected graph serialization:
// Nodes are labeled uniquely.

// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.

// The graph has a total of three nodes, and therefore contains three parts as separated by #.

// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:

//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

public class Solution {
	//BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        LinkedList<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        que.offer(node);
        map.put(node, copy);

        while(!que.isEmpty()){
        	UndirectedGraphNode curr = que.poll();
        	for(int i = 0; i < curr.neighbors.size(); i++){  // .size()!!
        		if(!map.containsKey(curr.neighbors.get(i))){
        			que.offer(curr.neighbors.get(i));
        			copy = new UndirectedGraphNode(curr.neighbors.get(i).label);
        			map.put(curr.neighbors.get(i), copy);
        		}
        		map.get(curr).neighbors.add(map.get(curr.neighbors.get(i)));
        	}
        }
        return map.get(node);
    }

    // DFS Recursion
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if(node == null) return null;
    	HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    	UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
    	map.put(node, copy);
    	clone(node, map);
    	return copy;
    }

    public void clone(UndirectedGraphNode node, HashMap<UndirectedGraphNode,UndirectedGraphNode> map){
    	for(int i = 0; i < node.neighbors.size(); i ++){
    		if(!map.containsKey(node.neighbors.get(i))){
    			UndirectedGraphNode copy = new UndirectedGraphNode(node.neighbors.get(i).label);
    			map.put(node.neighbors.get(i), copy);
    			clone(node.neighbors.get(i), map);
    		}
    		map.get(node).neighbors.add(map.get(node.neighbors.get(i)));
    	}
    }

    // DFS Stack
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {  
	    if(node == null)  
	        return null;  
	    LinkedList<UndirectedGraphNode> stack = new LinkedList<UndirectedGraphNode>();  
	    HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();  
	    stack.push(node);  
	    UndirectedGraphNode copy = new UndirectedGraphNode(node.label);  
	    map.put(node,copy);  
	    while(!stack.isEmpty())  
	    {  
	        UndirectedGraphNode cur = stack.pop();  
	        for(int i=0;i<cur.neighbors.size();i++)  
	        {  
	            if(!map.containsKey(cur.neighbors.get(i)))  
	            {  
	                copy = new UndirectedGraphNode(cur.neighbors.get(i).label);  
	                map.put(cur.neighbors.get(i),copy);  
	                stack.push(cur.neighbors.get(i));  
	            }  
	            map.get(cur).neighbors.add(map.get(cur.neighbors.get(i)));  
	        }  
	    }  
	    return map.get(node);  
	}  
}