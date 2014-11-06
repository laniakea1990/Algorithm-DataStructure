/*************************************************************************
    > File Name: list.c
    > Author: ma6174
    > Mail: ma6174@163.com 
    > Created Time: Sun 02 Nov 2014 10:40:57 PM PST
 ************************************************************************/
struct Node
{
	ElementType Element;
	Position Next;
};

/* Return true if L is empty */
int IsEmpty(List L)
{
	return L->Next == NULL;
}

/* Return true if P is the last position in list L */
/* Parameter L is unused in this implementation */

int IsLast(Position P, List L)
{
	return L->Next == NULL
}

/* Return Position of X in L; NULL if not found */

Position Find(ElementType X, List L)
{
	Position P;

	P = L->next;
	while(P != NULL && P->Element != X)
	{
		P = P->Next;
	}

	return P;
}

