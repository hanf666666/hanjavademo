# E:\资料\python相关\material\内存分析



# #1 服务gc 状态信息

jstat -gc -t 323903 10000 30 

# #查看堆内存信息

 jmap -histo 714776|head -n 20

# # dump 文件

 jmap -dump:format=b,file=/root/dump.hprof 1716

 



 