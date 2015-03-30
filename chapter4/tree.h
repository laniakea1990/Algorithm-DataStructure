/*************************************************************************
    > File Name: tree.h
    > Author: Gokuliz
    > Mail: jinranran1990910@163.com 
    > Created Time: Thu 01 Jan 2015 12:18:22 AM PST
 ************************************************************************/

typedef struct TreeNode *PtrToNode;

struct TreeNode{
	ElementType Element;
	PtrToNode FirstChild;
	PtrToNode NextSibling;
}
