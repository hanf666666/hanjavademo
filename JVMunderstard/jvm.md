# E:\����\python���\material\�ڴ����



# #1 ����gc ״̬��Ϣ

jstat -gc -t 323903 10000 30 

# #�鿴���ڴ���Ϣ

 jmap -histo 714776|head -n 20

# # dump �ļ�

 jmap -dump:format=b,file=/root/dump.hprof 1716

 



 