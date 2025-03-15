# Vim 基本操作

- 移动
  - gg 移动到首行
  - G 移动到底部
- 复制
  - yy 复制行
  - yG 复制当前行到文档末尾
- 删除
  - dd 删除当前行
  - dG 删除当前行到文档末尾
- 组合操作
  - gg dG 删除全部
  - gg yG 复制全部
- 搜索
  - /word 向后搜索 word
  - ?word 向前搜索 word
  - n 重复上一个搜索动作
  - N 反方向重复搜索
- 其他
  - u 撤销上一个操作

# Linux 基本操作
- mkdir: create folder
- touch : create file
- rm: delete file or folder
- rmdir: remove empty folder

# Log operation
- tail
  - tail -f filename : 循环读取文件
  - tail filename: 默认最后10行
- grep 在文件中查找特定模式
  - grep "example" *.txt 在当前目录搜索
  - grep -r "example" *.txt 在当前目录及子目录搜索

