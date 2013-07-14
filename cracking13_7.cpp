/*
Write a method that takes a pointer to a Node structure as a parameter and returns a complete copy of the passed in data structure. 
The Node data structure contains two pointers to other Nodes.
*/

typedef map<Node*, Node*> NodeMap;

Node* copy_recursive(Node* cur,NodeMap & nodeMap) {
    if(cur==null)
        return null;

    NodeMap::iterator i = nodeMap.find(cur);
    if(i!=nodeMap.end()) {
        //find cur,skip
        return i->second;
    }

    Node* node = new Node;
    nodeMap[cur] = node;
    node->ptr1 = copy_recursive(cur->ptr1,nodeMap);
    node->ptr2 = copy_recursive(cur->ptr2,nodeMap);

    return node;
}

Node * copy_structure(Node* root) {
    NodeMap nodeMap;
    return copy_recursive(root,nodeMap);
}
