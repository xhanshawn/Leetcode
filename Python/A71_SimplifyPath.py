class Solution:
    # @param {string} path
    # @return {string}
    def simplifyPath(self, path):
    	path = str(path)
        dirs = path.split('/')
        # print dirs, path
        result = []
        for d in dirs:
            if(d == '..'): 
            	if(len(result) > 0): result = result[:-1]
            elif(not d == '' and not d == "."):
                result.append(d)
        res = ""
        for r in result:
        	res += "/" + r
       	if(res == ""): return "/"
        return res
# accepted solution
# the rules is the key to solve this problem
# An absolute path always starts from the root directory, i.e. "/".
# "." represents the current directory itself.
# ".." goes upwards to the parent directory if exists. E.g. "/a/b/.." == "/a", while "/../" == "/".
# Redundant slashes can be ignored. E.g. "/a///b" == "/a/b"

s = Solution()
# print s.simplifyPath("/a/./b/../../c/")
# print s.simplifyPath("/home/")
# print s.simplifyPath("/..")
# print s.simplifyPath("/home//foo/")
print s.simplifyPath("/Z/Iyy/HSyT/ItVqc/.././//Z/.././.././../a/gK/../ZurH///x/../////././../..")


