```typescript
import { Editor } from '@milkdown/core';
import { nord } from '@milkdown/theme-nord';
import { commonmark } from '@milkdown/preset-commonmark';

Editor.make().use(nord).use(commonmark).use(history).create();
```

一般的
Ctrl+Shift+P、F1 显示命令面板
Ctrl+P 快速打开，转到文件...
Ctrl+Shift+N 新建窗口/实例
Ctrl+W 关闭窗口/实例
Ctrl+, 用户设置
Ctrl+K Ctrl+S 键盘快捷键
基本编辑
Ctrl+X 剪切线（空选）
Ctrl+C 复制行（空选）
Alt+ ↓ / ↑ 向下/向上移动行
Ctrl+Shift+K 删除行
Ctrl+Enter /
Ctrl+Shift+Enter
在下方/上方插入行
Ctrl+Shift+\ 跳转到匹配的括号
Ctrl+] / Ctrl+\[ 缩进/缩进行
Home / End 转到行首/行尾
Ctrl+ Home / End 转到文件的开头/结尾
Ctrl+ ↑ / ↓ 向上/向下滚动行
Alt+ PgUp / PgDn 向上/向下滚动页面
Ctrl+Shift+ \[ / ] 折叠/展开区域
Ctrl+K Ctrl+ \[ / ] 折叠/展开所有子区域
Ctrl+K Ctrl+0 /
Ctrl+K Ctrl+J
折叠/展开所有区域
Ctrl+K Ctrl+C 添加行注释
Ctrl+K Ctrl+U 删除行注释
Ctrl+/ 切换行注释
Ctrl+Shift+A 切换块注释
Alt+Z 切换自动换行
丰富的语言编辑
Ctrl+Space, Ctrl+I 触发建议
Ctrl+Shift+Space 触发参数 提示
Ctrl+Shift+I 格式化文档
Ctrl+K Ctrl+F 格式选择
F12 转到定义
Ctrl+Shift+F10 查看定义
Ctrl+K F12 打开定义到一边
Ctrl+。 快速解决
Shift+F12 显示引用
F2 重命名符号
Ctrl+K Ctrl+X 修剪尾随空格
Ctrl+K M 更改文件语言
多光标和选择
Alt+单击 插入光标\*
Shift+Alt+ ↑ / ↓ 在上方/下方插入光标
Ctrl+U 撤销上次光标操作
Shift+Alt+I 在选定的每一行的末尾插入光标
Ctrl+L 选择当前行
Ctrl+Shift+L 选择所有出现的当前选择
Ctrl+F2 选择所有出现的当前单词
Shift+Alt + → 展开选择
Shift+Alt + ← 缩小选择
Shift+Alt + 鼠标拖动 列（框）选择
展示
F11 切换全屏
Shift+Alt+0 切换编辑器布局（水平/垂直）
Ctrl+ = / - 放大/缩小
Ctrl+B 切换侧边栏可见性
Ctrl+Shift+E 显示资源管理器/切换焦点
Ctrl+Shift+F 显示搜索
Ctrl+Shift+G 显示源代码管理
Ctrl+Shift+D 显示调试
Ctrl+Shift+X 显示 扩展
Ctrl+Shift+H 在文件中替换
Ctrl+Shift+J 切换搜索详情
Ctrl+Shift+C 打开新的命令提示符/终端
Ctrl+K Ctrl+H 显示输出面板
Ctrl+Shift+V 打开 Markdown 预览
Ctrl+K V 打开 Markdown 预览到一边
Ctrl+K Z Zen 模式（Esc Esc 退出）
搜索和替换
Ctrl+F 查找
Ctrl+H 替换
F3 / Shift+F3 查找下一个/上一个
Alt+Enter 选择所有出现的查找匹配项
Ctrl+D 将选择添加到下一个查找匹配项
Ctrl+K Ctrl+D 将上一个选择移到下一个查找匹配项
导航
Ctrl+T 显示所有符号
Ctrl+G 转到行...
Ctrl+P 转到文件...
Ctrl+Shift+O 转到符号...
Ctrl+Shift+M 显示问题面板
F8 转到下一个错误或警告
Shift+F8 转到上一个错误或警告
Ctrl+Shift+Tab 导航编辑器组历史记录
Ctrl+Alt+- 返回
Ctrl+Shift+- 前进
Ctrl+M Toggle Tab 移动焦点
编辑管理
Ctrl+W 关闭编辑器
Ctrl+K F 关闭文件夹
Ctrl+\ 拆分编辑器
Ctrl+ 1 / 2 / 3 聚焦到 1
st、2、3编辑组
Ctrl+K Ctrl + ← 聚焦到上一个编辑器 团体
Ctrl+K Ctrl + → 聚焦到下一个编辑器组
Ctrl+Shift+PgUp 向左移动编辑器
Ctrl+Shift+PgDn 向右移动编辑器
Ctrl+K ← 向左/向上移动活动编辑器组
Ctrl+K → 向右/向下移动活动编辑器组
文件管理
Ctrl+N 新建文件
Ctrl+O 打开文件...
Ctrl+S 保存
Ctrl+Shift+S 另存为...
Ctrl+W 关闭
Ctrl+K Ctrl+W 全部关闭
Ctrl+Shift+T 重新打开关闭的编辑器
Ctrl+K Enter 保持预览模式编辑器打开
Ctrl+Tab 打开下一个
Ctrl+Shift+Tab 打开上一个
Ctrl+K P 复制活动文件的路径
Ctrl+K R 在资源管理器中显示活动文件
Ctrl+K O 在新窗口/实例中显示活动文件
调试
F9 切换断点
F5 开始/继续
F11 / Shift+F11 进入/退出
F10 跳过
Shift+F5 停止
Ctrl+K Ctrl+I 显示悬停
集成终端
Ctrl+\`  显示集成终端
Ctrl+Shift+\` 创建新终端
Ctrl+Shift+C 复制选择
Ctrl+Shift+V 粘贴到活动终端
Ctrl+Shift+ ↑ / ↓ 向上/向下滚动
Shift+ PgUp / PgDn 向上/向下滚动页面
Shift+ Home / End 滚动到顶部/底部

  \*Alt+Click 手势可能不适用于某些 Linux 发行版。
  您可以将插入光标命令的修饰键更改为
  Ctrl+单击“editor.multiCursorModifier”设置。
