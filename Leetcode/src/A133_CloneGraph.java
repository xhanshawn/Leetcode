import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import data.UndirectedGraphNode;


public class A133_CloneGraph {
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        
        if(node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.add(node);
        UndirectedGraphNode graphCopy = new UndirectedGraphNode(node.label);
        map.put(node, graphCopy);
        while(!q.isEmpty()) {
        
            UndirectedGraphNode first = q.poll();
            for(UndirectedGraphNode neighbor : first.neighbors) {
                if(map.containsKey(neighbor)) {
                    
                    map.get(first).neighbors.add(map.get(neighbor));
                } else {
                    
                    UndirectedGraphNode neighborCopy = new UndirectedGraphNode(neighbor.label);
                    map.get(first).neighbors.add(neighborCopy);
                    map.put(neighbor, neighborCopy);
                    q.add(neighbor);
                }
            }
            
        }  
        
        return graphCopy;
    }
}
