
class TrieNode(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.d = {}
        self.prefix = ''
    def get(self, c):
        return self.d.get(c, None)
    def put(self, c, node):
        self.d[c] = node
        # print self.d

class Trie(object):

    def __init__(self):
        self.root = TrieNode()
        self.words = set()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        n = self.root
        for i in xrange(len(word)):
            d = n.get(word[i])
            if(d): n = d
            else: 
                node = TrieNode()
                node.prefix = word[:i + 1]
                n.put(word[i], node)
                n = node
        self.words.add(word)
        

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        # n = self.root
        # for i in xrange(len(word)):
        #     if(n.prefix == word): 
        #         return not n.d
        #     # print n.d, prefix[i]
        #     d = n.get(word[i])
        #     if(not d): return False
        #     n = d
        # return not n.d
        return word in self.words

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie
        that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        n = self.root
        for i in xrange(len(prefix)):
            if(n.prefix == prefix): return True
            # print n.d, prefix[i]
            d = n.get(prefix[i])
            if(not d): return False
            n = d
        return True


class WordDictionary(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.trie = {}
    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        if(len(word) not in self.trie): self.trie[len(word)] = {}
        t = self.trie[len(word)]
        for c in word:
            d = t.get(c, {})
            t[c] = d
            t = d

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could
        contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """
        self.res = False
        if(not word or len(word) not in self.trie): return False
        self.dfs(self.trie[len(word)], word, 0)
        return self.res
    def dfs(self,t,word, i):
        if(i >= len(word)): 
            self.res = not t
            return 
        if(not t): return
        if(word[i] == '.'):
            for e in t:
                self.dfs(t[e],word, i + 1)
        else:
            if(word[i] not in t): return
            # print t[word[i]], word, i + 1
            self.dfs(t[word[i]],word, i + 1)
# ac solution                    


# Your WordDictionary object will be instantiated and called as such:
wordDictionary = WordDictionary()
wordDictionary.addWord("a")
wordDictionary.addWord("ab")

print wordDictionary.search("a")
print wordDictionary.search(".ad")
print wordDictionary.search('...')