/*************************************************************************
    > File Name: directory_traversal.h
    > Author: Gokuliz
    > Mail: jinranran1990910@163.com 
    > Created Time: Thu 01 Jan 2015 12:46:13 AM PST
 ************************************************************************/

static void ListDir(DirectoryOrFile D, int Depth)
{
	if(D is a legitimate entry)
	{
		PrintName(D, Depth);
		if(D is a directory)
			for each child, C, of D
				ListDir(C, Depth + 1);
	}
}
void ListDirectory(DirectoryOrFile D)
{
	ListDir(D, 0);
}
