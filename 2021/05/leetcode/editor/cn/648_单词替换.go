package main

import "strings"

//在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，
//跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
//
// 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
//
// 你需要输出替换之后的句子。
//
//
//
// 示例 1：
//
// 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by th
//e battery"
//输出："the cat was rat by the bat"
//
//
// 示例 2：
//
// 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
//输出："a a b c"
//
//
// 示例 3：
//
// 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa a
//aa aaaaaa bbb baba ababa"
//输出："a a a a a a a a bbb baba a"
//
//
// 示例 4：
//
// 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattle
//d by the battery"
//输出："the cat was rat by the bat"
//
//
// 示例 5：
//
// 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is
// accepted"
//输出："it is ab that this solution is ac"
//
//
//
//
// 提示：
//
//
// 1 <= dictionary.length <= 1000
// 1 <= dictionary[i].length <= 100
// dictionary[i] 仅由小写字母组成。
// 1 <= sentence.length <= 10^6
// sentence 仅由小写字母和空格组成。
// sentence 中单词的总量在范围 [1, 1000] 内。
// sentence 中每个单词的长度在范围 [1, 1000] 内。
// sentence 中单词之间由一个空格隔开。
// sentence 没有前导或尾随空格。
//
// Related Topics 字典树 哈希表
// 👍 119 👎 0

//leetcode submit region begin(Prohibit modification and deletion)

type replaceWordTreeNode struct {
	end    bool
	childs []*replaceWordTreeNode
}

func ConstructNode() replaceWordTreeNode {
	return replaceWordTreeNode{
		end:    false,
		childs: make([]*replaceWordTreeNode, 32),
	}
}

func (t *replaceWordTreeNode) add(word string) {
	cur := t
	for _, w := range word {
		idx := w - 'a'
		if cur.childs[idx] == nil {
			node := ConstructNode()
			cur.childs[idx] = &node
		}
		cur = cur.childs[idx]
	}
	cur.end = true
}

func (t *replaceWordTreeNode) checkPrefix(word string) (bool, string) {
	cur := t
	var sb strings.Builder
	for _, w := range word {
		idx := w - 'a'
		if cur.childs[idx] != nil {
			sb.WriteRune(w)
			if cur.childs[idx].end {
				return true, sb.String()
			}
			cur = cur.childs[idx]
		} else {
			return false, ""
		}
	}

	if cur.end {
		return true, sb.String()
	}
	return false, ""
}

func replaceWords(dictionary []string, sentence string) string {
	root := ConstructNode()
	for _, d := range dictionary {
		root.add(d)
	}

	arrs := strings.Split(sentence, " ")
	for i := range arrs {
		queied, prefix := root.checkPrefix(arrs[i])
		if queied {
			replace := strings.Replace(arrs[i], arrs[i], prefix, 1)
			arrs[i] = replace
		}
	}

	join := strings.Join(arrs, " ")
	return join
}

//leetcode submit region end(Prohibit modification and deletion)
