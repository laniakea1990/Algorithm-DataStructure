/*************************************************************************
    > File Name: stack_array.h
    > Author: ma6174
    > Mail: ma6174@163.com 
    > Created Time: Wed 19 Nov 2014 04:03:29 AM PST
 ************************************************************************/

#ifndef _Stack_h

struct StackRecord;
typedef struct StructRecord *Stack;

int IsEmpty(Stack S);
int IsFull(Stack S);
Stack CreateStack(int MaxElements);
void DisposeStack(Stack S);
void MakeEmpty(Stack S);
void Push(Element X, Stack S);
ElementType Top(Stack S);
void Pop(Stack S);
ElementType TopAndPop(Stack S);

#endif	/*_stack_h */

/* Place in implementation file */
/* Stack implementation is a dynamically allocated array */

#define EmptyTOS (-1)
#define MinStackSize (5)

struct StackRecord
{
	int Capacity;
	int TopOfStack;
	ElementType *Array;
};

Stack CreateStack(int MaxElements)
{
	Stack S;

	if(MaxElements < MinStackSize)
		Error("Stack size is too small");

	S = malloc(sizeof(struct StackRecord));
	if(S == NULL)
		FatalError("Out of space!!!");

	S->Array = malloc(sizeof((ElementType) * MaxElements));
	if(S->Array == NULL)
		FatalError("Out of space");
	S->Capacity = MaxElements;
	MakeEmpty(S);

	return S;
}

void DisposeStack(Stack S)
{
	if(S != NULL)
	{
		free(S->Array);
		free(S);
		//释放内存之后原来的指针的地址不变，只是指向的内存可以重新分配了，最好将free后从指针赋值为NULL；
	}
}

int IsEmpty(Stack S)
{
	return S->TopOfStack == EmptyTOS;
}

void MakeEmpty(Stack S)
{
	S->TopOfStack =EmptyTOS;
}

void Push(ElementType X, Stack S)
{
	if(IsFull(S))
		Error("Full Stack!");
	else
		S->Array[++S->TopOfStack] = X;
}

ElementType(Stack S)
{
	if(!IsEmpty(S))
		return S->Array[S->TopOfStack];
	Error("Empty Stack");
	return 0; /*return value used to avoid warning */
}

void Pop(Stack S)
{
	if(IsEmpty(S))
		Error("Empty stack");
	else
		S->TopOfStack--;
}

ElementType TopAndPop(Stack S)
{
	if(!IsEmpty(S))
		return S->Array[S->TopOfStack--];
	Error("Empty stack");
	return 0; /*Return value used to avoid warning */
}

