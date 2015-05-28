# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @return {ListNode}
def swap_pairs(head)
    @dummy = ListNode.new(0)
    @dummy.next = head
    @parent = @dummy
    while head != nil && head.next != nil
        
        node_2 = head.next
        node_3 = head.next.next
        
        @parent.next = node_2 if @parent != nil
        @parent = head
        
        head.next = node_3
        node_2.next = head
        
        head = head.next
    end
    
    return @dummy.next
end