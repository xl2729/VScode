linux中Shell历史命令记录文件的路径是什么

caolaosanahnu 2012-05-25 10:52:48  33457  收藏 15
分类专栏： Unix 文章标签： shell linux service bash command network
版权

Unix
专栏收录该内容
92 篇文章0 订阅
订阅专栏

Bash shell在“/.bash\_history”（“/”表示用户目录）文件中保存了500条使用过的命令，这样能使你输入使用过的长命令变得容易。每个在系统中拥有账号的用户在他的目录下都有一个“.bash\_history”文件。

bash shell应该保存少量的命令，并且在每次用户注销时都把这些历史命令删除。
第一步：
“/etc/profile”文件中的“HISTFILESIZE”和“HISTSIZE”行确定所有用户的“.bash\_history”文件中能保
存的旧命令条数。强烈建议把把“/etc/profile”文件中的“HISTFILESIZE”和“HISTSIZE”行的值设为一个较小的数，比如
30。编辑profile文件（vi /etc/profile），把下面这行改为：
HISTFILESIZE=30
HISTSIZE=30
这表示每个用户的“.bash\_history”文件只能保存30条旧命令。
第二步：
网管还应该在"/etc/skel/.bash\_logout" 文件中添加下面这行"rm -f \$HOME/.bash\_history" 。这样，当用户每次注销时，“.bash\_history”文件都会被删除.

<http://www.huanxiangwu.com/137/linux-history%E5%91%BD%E4%BB%A4%E4%BB%8B%E7%BB%8D>

现在大多数的Linux系统都使用bash作为默认的shell吧，下面就介绍一下bash的history命令管理功能吧，history命令可以回顾，修改和重用之前使用过的历史命令。

1.一些变量说明：

\$HISTFILE bash启动的时候会读取\~/.bash\_history文件并载入到内存中，这个变量就用于设置.bash\_history文件，bash退出时也会把内存中的历史回写到.bash\_history文件

\$HISTSIZE 设置bash会员期间历史包含的命令数量

\$HISTFILESIZE 设置历史文件中实际存储的命令数量

2.显示历史命令

history 显示全部历史

history 数字 显示之前执行过的若干命令，例：history 2 显示执行过的上两条命令

使用上下箭头键也可以查看上一条根下一条命令，

3.运行历史命令

!! 运行上一条命令

!88 运行第88条命令

!88 /test 运行第88条命令并在命令后面加上/test

!?CF? 运行上一个包含CF字符串的命令

!ls 运行上一个ls命令

!ls:s/CF/l 运行上一个ls命令，其中把CF替换成l

fc 编辑并运行上一个历史命令

fc 66 编辑并运行第66个历史命令

fc -e /usr/bin/vim 66 使用vim编辑第66个命令并运行

4.搜索历史命令

使用ctrl+r搜索历史中的字符串，重复按ctrl+r可以在历史命令列表中不断的向前搜索包含字符串的命令，回车就会执行查找的命令

5.清空历史命令

history -c

6.写history

history -w 让bash将历史命令立即从内存写到.bash\_history文件

history -a 将目前新增的 history 历史命令写入.bash\_history文件

7.history历史命令记录删除

修改/etc/profile将HISTSIZE=1000改成0或1

清除用户home路径下.bash\_history

8.history配置

运行 set | grep HISTFILE

显示：HISTFILE=/root/.bash\_history
HISTFILESIZE=1000

在.bash\_profile文件中添加

HISTFILE=/root/history

export HISTFILE

重新登录后历史命令都会写入到/root/history文件中

其余的一些设置可以在.bashrc文件中设置

export HISTCONTROL=ignoredups #忽略重复的命令

export HISTIGNORE=”\[ ]\*:&:bg:fg:exit” #忽略由冒号分割的这些命令

export HISTFILESIZE=1000 #设置保存的历史命令的文件大小

export HISTSIZE=100 #设置保存的历史命令的条数

技巧：

shopt -s histappend 在shell中执行这个命令可以使shell保存历史命令的时候使用追加的方式，因为默认是覆盖，在多终端的清空下，最后退出的终端灰覆盖以前的历史记录

在history历史记录中显示时间和执行命令的用户 echo ‘export HISTTIMEFORMAT=”%F %T \`whoami\` “‘ >> /etc/profile

<http://linuxtoy.org/archives/history-command-usage-examples.html>

History（历史）命令用法 15 例
2008-09-07 Toy Posted in Cli, Featured, TipsRSSTrackback

如果你经常使用 Linux 命令行，那么使用 history（历史）命令可以有效地提升你的效率。本文将通过实例的方式向你介绍 history 命令的 15 个用法。

使用 HISTTIMEFORMAT 显示时间戳

当你从命令行执行 history 命令后，通常只会显示已执行命令的序号和命令本身。如果你想要查看命令历史的时间戳，那么可以执行：

\# export HISTTIMEFORMAT='%F %T '

\# history | more

1  2008-08-05 19:02:39 service network restart
2  2008-08-05 19:02:39 exit
3  2008-08-05 19:02:39 id
4  2008-08-05 19:02:39 cat /etc/redhat-release

注意：这个功能只能用在当 HISTTIMEFORMAT 这个环境变量被设置之后，之后的那些新执行的 bash 命令才会被打上正确的时间戳。在此之前的所有命令，都将会显示成设置 HISTTIMEFORMAT 变量的时间。\[感谢 NightOwl 读者补充]

使用 Ctrl+R 搜索历史

Ctrl+R 是我经常使用的一个快捷键。此快捷键让你对命令历史进行搜索，对于想要重复执行某个命令的时候非常有用。当找到命令后，通常再按回车键就可以执行该命令。如果想对找到的命令进行调整后再执行，则可以按一下左或右方向键。

\# \[Press Ctrl+R from the command prompt, which will display the reverse-i-search prompt]

(reverse-i-search)\`red‘: cat /etc/redhat-release
\[Note: Press enter when you see your command, which will execute the command from the history]

\# cat /etc/redhat-release

Fedora release 9 (Sulphur)

快速重复执行上一条命令

有 4 种方法可以重复执行上一条命令：

使用上方向键，并回车执行。
按 !! 并回车执行。
输入 !-1 并回车执行。
按 Ctrl+P 并回车执行。
从命令历史中执行一个指定的命令

在下面的例子中，如果你想重复执行第 4 条命令，那么可以执行 !4：

\# history | more

1  service network restart
2  exit
3  id
4  cat /etc/redhat-release

\# !4

cat /etc/redhat-release
Fedora release 9 (Sulphur)

通过指定关键字来执行以前的命令

在下面的例子，输入 !ps 并回车，将执行以 ps 打头的命令：

\# !ps

ps aux | grep yp
root     16947  0.0  0.1  36516  1264 ?        Sl   13:10   0:00 ypbind
root     17503  0.0  0.0   4124   740 pts/0    S+   19:19   0:00 grep yp

使用 HISTSIZE 控制历史命令记录的总行数

将下面两行内容追加到 .bash\_profile 文件并重新登录 bash shell，命令历史的记录数将变成 450 条：

\# vi \~/.bash\_profile

HISTSIZE=450
HISTFILESIZE=450

使用 HISTFILE 更改历史文件名称

默认情况下，命令历史存储在 \~/.bashhistory 文件中。添加下列内容到 .bashprofile 文件并重新登录 bash shell，将使用 .commandline\_warrior 来存储命令历史：

\# vi \~/.bash\_profile

HISTFILE=/root/.commandline\_warrior

使用 HISTCONTROL 从命令历史中剔除连续重复的条目

在下面的例子中，pwd 命令被连续执行了三次。执行 history 后你会看到三条重复的条目。要剔除这些重复的条目，你可以将 HISTCONTROL 设置为 ignoredups：

\# pwd

\# pwd

\# pwd

\# history | tail -4

44  pwd
45  pwd
46  pwd \[Note that there are three pwd commands in history, after executing pwd 3 times as shown above]
47  history | tail -4

\# export HISTCONTROL=ignoredups

\# pwd

\# pwd

\# pwd

\# history | tail -3

56  export HISTCONTROL=ignoredups
57  pwd \[Note that there is only one pwd command in the history, even after executing pwd 3 times as shown above]
58  history | tail -4

使用 HISTCONTROL 清除整个命令历史中的重复条目

上例中的 ignoredups 只能剔除连续的重复条目。要清除整个命令历史中的重复条目，可以将 HISTCONTROL 设置成 erasedups：

\# export HISTCONTROL=erasedups

\# pwd

\# service httpd stop

\# history | tail -3

38  pwd
39  service httpd stop
40  history | tail -3

\# ls -ltr

\# service httpd stop

\# history | tail -6

35  export HISTCONTROL=erasedups
36  pwd
37  history | tail -3
38  ls -ltr
39  service httpd stop
\[Note that the previous service httpd stop after pwd got erased]
40  history | tail -6

使用 HISTCONTROL 强制 history 不记住特定的命令

将 HISTCONTROL 设置为 ignorespace，并在不想被记住的命令前面输入一个空格：

\# export HISTCONTROL=ignorespace

\# ls -ltr

\# pwd

\# service httpd stop \[Note that there is a space at the beginning of service, to ignore this command from history]

\# history | tail -3

67  ls -ltr
68  pwd
69  history | tail -3
使用 -c 选项清除所有的命令历史

如果你想清除所有的命令历史，可以执行：

\# history -c

命令替换

在下面的例子里，!!:\$ 将为当前的命令获得上一条命令的参数：

\# ls anaconda-ks.cfg

anaconda-ks.cfg

\# vi !!:\$

vi anaconda-ks.cfg

补充：使用 !\$ 可以达到同样的效果，而且更简单。\[感谢 wanzigunzi 读者补充]

下例中，!^ 从上一条命令获得第一项参数：

\# cp anaconda-ks.cfg anaconda-ks.cfg.bak

anaconda-ks.cfg

\# vi -5 !^

vi anaconda-ks.cfg

为特定的命令替换指定的参数

在下面的例子，!cp:2 从命令历史中搜索以 cp 开头的命令，并获取它的第二项参数：

\# cp \~/longname.txt /really/a/very/long/path/long-filename.txt

\# ls -l !cp:2

ls -l /really/a/very/long/path/long-filename.txt

下例里，!cp:\$ 获取 cp 命令的最后一项参数：

\# ls -l !cp:\$

ls -l /really/a/very/long/path/long-filename.txt

使用 HISTSIZE 禁用 history

如果你想禁用 history，可以将 HISTSIZE 设置为 0：

\# export HISTSIZE=0

\# history

\# \[Note that history did not display anything]

使用 HISTIGNORE 忽略历史中的特定命令

下面的例子，将忽略 pwd、ls、ls -ltr 等命令：

\# export HISTIGNORE=”pwd:ls:ls -ltr:”

\# pwd

\# ls

\# ls -ltr

\# service httpd stop

\# history | tail -3

79  export HISTIGNORE=”pwd:ls:ls -ltr:”
80  service httpd stop
81  history
\[Note that history did not record pwd, ls and ls -ltr]
————————————————
版权声明：本文为CSDN博主「caolaosanahnu」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：<https://blog.csdn.net/caolaosanahnu/article/details/7601074>
