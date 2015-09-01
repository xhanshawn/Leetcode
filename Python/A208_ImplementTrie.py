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
# AC solution

# Your Trie object will be instantiated and called as such:
trie = Trie()
trie.insert("word")
print trie.search("wor")
print trie.startsWith('')








