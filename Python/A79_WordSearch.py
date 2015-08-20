class Solution:
    # @param {character[][]} board
    # @param {string} word
    # @return {boolean}
    def exist(self, board, word):
        self.res = False
        if(not self.pre_check(board, word)): return False
        if(len(board) == 0 or word == ''): return False
        for i in range(len(board)):
            for j in range(len(board[0])):
                if(self.res): return True
                if(board[i][j] == word[0]): 
                    visited = [[False for y in xrange(len(board[0]))] for x in xrange(len(board))]
                    self.search(board, word[1:], i, j, visited)
        return self.res
    def pre_check(self, board, word):
        lw, li, lj = len(word), len(board), len(board[0])
        if(lw > li * lj): return False
        d = {}
        for line in board:
            for c in line:
                if(c in d): d[c] += 1
                else: d[c] = 1
        for c in word:
            if(c not in d or d[c] == 0): return False
            d[c] -= 1
        return True
    def search(self, board, word, i, j, visited):
        # print board[i][j], i, j, word
        if(visited[i][j]): return
        if(word == ''): 
            self.res = True
            return
        visited[i][j] = True
        if(i + 1 < len(board) and board[i + 1][j] == word[0]): self.search(board, word[1:], i + 1, j, visited)
        if(i > 0 and board[i - 1][j] == word[0]): self.search(board, word[1:], i - 1, j, visited)
        if(j + 1 < len(board[0]) and board[i][j + 1] == word[0]): self.search(board, word[1:], i, j + 1, visited)
        if(j > 0 and board[i][j - 1] == word[0]):self.search(board, word[1:], i, j - 1, visited)
        if(self.res): return
        visited[i][j] = False
# Accepted solution.. my god!
s = Solution()
board = ['ABCE', 'SFCS', 'ADEE']
word1 = 'ABCCED'
word2 = 'SEE'
word = 'ABCB'
board = ["CAA","AAA","BCD"]
word = "AAB"
board = ["drgimmrzmyioqlbpeezsegxlohvwheslvatjmkkylsobgqskwtebbemqljosngdjgz","sulfuwxiafassxowypamhnyvgldlwlkrfwwzuvkwbkpvhfrhuuwcjuzpfddeopvunr","vkmfgpsxkzccjzyfbhzazgfekuthqhyltltzalxnmzpvypabybexkjbwfxevgchzpc","ysnxfbxwxxnzbldhlnqojynnttscsjetdtqkvpiupvtqjwxwlpkvnykhteloqqhtlz","ggpocgmwwvuvrgmddadnjxuulkmufyvlgmcjsohqjdlcjafoajeliyhtkwppukdcxf","lptugeytghtnyvwciecqzmmodibgkylyngsvkqrqakgygccojegkqubteccranppuj","ngaexcofcwhensivfaqgvwiznknezjompqqouhtwddcqxmocogkjcslscawcjmqaej","raqmwvraormcvaigmkyxcdxbhipxkwgbwyqvujviakkwkscwecvjfsmmcbknzsoytg","vnqsxqchopbqnfvjoadangeztftjdmqabityavhpkihyocjefmhssntnsoxydpyezr","fzpmobvyblckrhzybtnujilggoxgswaxvpkmshmwsoijwhkzdxwmfhunvrunpunmlz","afgmbadkjbtvawvwicdeqaxmqmidbvcbakqckvovwhryemvooatgbqsrfcwgxajymb","cwwqtuxktdyqspsnxtdqmksksskeqyfsuekoyharlbhfqasnvxfkkawcsjgkhoeeso","ssxukkvtpnvjdtjkftkbxemgquuuyoisggmsskoixltcgcnlvzptebzuvvrvjbnrjc","mcmaklldouidfdcwyiyxfvuwrfxgxhijjulviyawsizamdwmmukrsgpjmmpjvaueuh","behccambcahyntvzmnfbyrnpclpyrmftqnxtpjwtkdrxyowkbblbtbrxogwfsdylsv","ejfccriuogiktmngnihggxnedhhbuazajgdmxlilrsxkgktwtacbyrfdzmevofwylz","mimwtdoqqxdjtylvzlngqouvjjcfjoexwqtswjkognzzlmvmakuqypnhyqnjetgcmz","ukkfarszqgnnupxpgvevfelunrpvubwqngvnxqoqyedstdjbanxftkbierdyuzqiim","xfemxeqbwlgingxkorwpzaifafgrpofmwjatnqwlcctrlrbzkzqlabsagzrvpwhnhk","jwahkemfxxyyyiyqwatoazpuwhqgwaqfyspizbqwaoxazxqxxmlxndtkmksimiqmcf","xbgnyidxicuabtmnsasmmeyemkocwqjtupiuzmrhqnksgyhyyzkmfisrsgwrzfmtxx","nyjegzrstxqavrbidgqwaleyedfqwepjdyplaidthtwfmxnsgdoiquguynnuscgvbx","gdglypguutuhlcnbkdvsytflqxnysqxatfluvsoplkzymmzwrwqpswcitsioifoela","yguoxfzwdnkemcactsywcsomgyswefyensvkxwjcjtivxlyrdypisfuafoxktvqiol","tnhestzcoxnoqrnfbhkvirkfbfcuoqfjgpnaiocylqndjcikluhtmrapzdjnvrybin","dqbgqpwdshhdrtxaolupdtsoinfgrpvwfwcylabghljaggbuuvlxqdlyttgmibiqxn","olnrrveaxkiyhevsblypjtirfsspiscyfqqynuakhilqpgkqsihdbpviipyshcrosh","mhdmumxfcmlnefvmjzbehlvhedkxteegmjsgwrlydyliejunkxtrlozrtlonpuvbdp","jzhuakvnuzyqoiqhabxbsrmigdcbffqohxlhkiughtxvbnedqbgkuuscyudfzwvgvi","pfqkmzflwiaaoqeuayrubrogwpctyacnhuzvuegqngrbyxxavouyfihdylxylbltvl","oprxggfzjeyhevxzufjdijohhcivxggnvzkdgsepwcycywdudnxlynvgrfboljchio","mogtgevehvckpfzotycoevthkhqmoaccrjvxprdwoijeniuigyymuuveblsroutffp","cvihtwpccflxntvoipidtjrnafktkrkomuxirpkvuxsjtoxbffgbqxoseyoqqyeete","mmtzhnwcypqwsvdzyuynmdnatfbakweykzxrmwtklligjmhhifuwkkzgpagzymailx","bztvlhiupriwbqbxomhnsxpaynoyxbyzarwlaehpyplzhpwwbelvdbxbqlcomanmtj","zwnhllwzmgojcrpnosqlvhwxxkzkytvxrkgcyfdkltvpkkcyevjaehzbrbnpwipnsv","rsavdnoycblhzpclriutjmwwdsgshaqytsvygmyinjrobtbudwpmklkndsiktylosg","myukjjwaaxwbtzxjohuaxatfmmfzazimycyjmulmtjpnlnyzwuzvwscjghighsuhvv","sjpdvlpkaazybysatpvwadfkmodixydphvvegkqgksglqanlpkhropcadfibfmsojn","urxkzjcfwufkgxunokeqkkxvnejfssvmjuziebpawwmethtityaeiabvekazcvnnqm","xwqmyoilseulonlqrtquoxeryiolvgauesiditocxiplvbbpuujltoeryueubeqhyz","kguyirgyeebhtvbeiuuontjspmwftxgedaeorloxrpfmmiqvfljseuktgjacghgjjm","zdxnaqchcpqtmvgxpksafajhcrokcaxcdwrdpulrldkzaqwpcqrjrcrvthiyhfakdr","qsndmagwbipyztqrdhvufrbnpjurvzkluaogcwceeteenuxseumjnpycasvwtihniw","tkuyqzrufgreavamgoegseaoatwkhgiascajbufiawodtprbdvhxahlcdjmkrumkxn","vahaljzzmuoewtbfrbpeesqsehnqrmfmmopxyozmipsgluocvfibzyudgjvzvbojpd","hpriebxwkiqamofvrevnjdwedthrdzwkqpsuqrrcajcmxjjppfeyibfnuogxpcjgrd","akxtoxdrlacvrsawqkzxyvmevbjgjcmkmjfdgiurlwoeqoajbbgzxufuyqahtmthvz","kdhgxuflzvcbgddnecjlyheyrznkgiltovblpgyoeaskfxzlzlxxsbxlakyivjdjef","wunuktxcgczhoasnznqzysjwagggpmlngaitufxajzjzbcmdpccpulmxuufjgqzpsh","kmohozgyzkclntqpimcwlwqqizihobqapghefqegaisnbkcjyegkbyalzlsnmkpbqx","hxnnenvycwieigkqsnovyogsductxssfqfuuuquyocewkomfedaetgxycztzulgmsb","iorcmhgqgshuxlxxrsforhqmhmypysqihjmvrsoxkxrikrfblnqeuirdurvujlesvq","qoignudgcnxkqlxgptqgzmzuilfmdccvsmbfhemjtlvkwssmojunxujgfqsktxgljj","tqqfajqvtnqobezvtwreeyuxlpwtdfcwwsbyetvzinnjtmhmlaspznokckdfqhboae","meyjdgxtsqfzfszxiamwkpjpwzxypzcddcmillbdejelbfklgxksotikufijenmjry","tcmxfqglbjrlxxkhpyaxjuetfkirvarpedmktuvwfokclulbvlaghhzmtkfpmxeqas","awmystmcwazhduvfcembtgnyvzvbqwtsuhsmahrwhsgkodpqhetamhzhgwkyudroml","dmsulzotlcwdsdjnevufedbodwtumfgptaleczxpbtsvzdjfyfkcknsolliyqqpkrb","qvcqkgjfbkimpjuznepgsatdakvqwotojveubqzfahrqsnrgsgmkjfpjrlzpbsglqk","hrcgwdpqvidoqxxeigjzpdmruolabbnitpqrufjrpnihkflulxuaaitwwfxxgmfbdx","tadcrurzccepyrmusmdllzskzzwgazetzjytfpujtzzsslmmapalrsvsrryusenunn","ntdhewidobpdnrsnclgxdzqetkijeywrtbbxylboosrcjmrnzzkfbcjumtfrrckmfn","kdznspflrqxldxmpcnrnkfipwatjozyyezlypskiijtliiamxrzhxizvkugyvfzagk","avfkenwzzehztftsoscppokyphfqjlckhhwlvukwzuvszqmpkrfahrayyfoiqruzys","kvnxrorpgshuhsnmuvfuvebkordkrdcdzpasfthnlpithxhdunxqtycjrftkixojpq","cukjivasqjpymknlailcrdjmnrjddyufvgqdbrvsamspwhaypmcgpnsehdkkegrzmh","epabjdnbsmiumzgrfxezeldoxhwogiykzyljdamvmxqzwyscwwbaieqfnmwvwuhvss","eyvrvholikmaoizskjwaqmomhkgphbjozefwoviyhwbweaoqlmsbagoiswzzzipapu","xdrhdzdgxjinztbtvcblmtjlujtklkgipyrtzuzyfingdozysaletvpqglcrvicnit","gjqhjvrwcvlbvdehkzebpmmrfkchxmdfwtmfqecubpwwucdebjgrvukbgokfbpkxkz","ebfivgxtcsviyxrgqpbaqjpcpqszpcytdfeblbuqvsywprcfgfhypybeotdfvebbjf","cxiyneqlaheemlkwjzukdlfisbmteyygvjeknxxpebttmdpyclkhwqqptekxcldzuj","jhigynkrgyxxwbihjhzzwsfipktujnfvwodudnojmlikmqrxzswxkegbozxzpfulta","iynwjbjrmxjfvjytgkxmmlolldqholhwjvuswdlibvqweopmypzmanalqqtgeadpxz","kwdvggqwewkvjlkkxlxzypqtvwwalvavrdryljupghmrsxbrkaripjekfalsvnopqh","ndqjuysgpmdsgnszyhicupehhzuxqmedpvpjthpluvdckwbifjmzaqgjsahimlodid","oemgpibuknslwywkxybgivgpfvctylynrntivwcijvthtsssqvyaqhrxcwrchrraem","icikkuhfbczvvsqvsicmgeizjrqarxnzzxjjrtqvvqqqijmcrqoxvwygnpiemvdnvp","yoiojdgawojktcahcxgadtpmadjdqeuotefeklggcrqvuqewokwteohetrjkxgaskf","xurdctxsqrlupbfnwlberxvahugjntpmnirsbomtfxnuaukzhndykaztuhdhastqal","idzuyhunduinvpbyolyphvwkczeypglxlmrjtnwzkgofypeodefmzbwecacripqtbk","exxcwhlknjctzhxetxhrdktfdbuuwxeaubesjpfyyjrzsodnnneqzzxcctwyraanee","gpwnnwwewosbbiohapgysitoimriaxoimkvzhtdfjxgmhxtimbiejbvtoodqltyzev","ynqduzcclkzguohcusdrltfojsjjtnercwwyvzbilaofqxhlpmccgksrecbyrhpweo","ubnvkayyfoyoznacqioiasmbqeiiaowuqjsalqaqeyggoikeryotqdwhhgphvldlwv","nhnnzsohycpiiiiybybxhkewtbjxmhuzqiorceycgomqyupasszcdfywgkvurqvkam","bcqaexqqpomeqgzsiczjaitwcmoawomascawbsoricxziwtrasabavxfhnfgbrgtvi","rxahqkjnltmekmzmnbhmgpznxcgdvcnobpxrzielcqrodqbsuihcxiqulyziamzbdw","sdfzqhphvuawpuhwweeobrncaprztuvlzcmplcxhyxfntmjrtqgwhvyjkridmgrlkd","dwhafgzmvuzfluxtseosqbkygygzlrfonmquupgqjhxvbuovafoqiyroyzqjsvyhho","begiurptotnfopkeiscbicaymtvmafccjkmfcdyqwnvnchrmzwnkyqkmlgalldpund","zrhxidmfqonidogqaeilrtrrfewwamazdjynmmvfaipdyvwzbeksydmfhidhwficoi","pdukkwuzctwasxgesehglqqrznwjpntgqntclpdpizpcywgscnaqfrhegfnxsgfkvy","mjopyyqqbrohlsxmicfrhlxukrdpcyqqheiieayfropfgmrpowixjfuvxxkbxathgb"]
word = "lcpsvdhalttairlfa"
board = ["ABCE","SFES","ADEE"]
word = "ABCESEEEFS"
board = ["ABCE","SFES","ADEE"]
word = "ABCEFSADEESE"
board = ["b","a","b","b","a"]
word = "baa"
# board = ["aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaaaaaab"]
# word = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
# print len(word), len(board), len(board[0])
print s.exist(board, word)




