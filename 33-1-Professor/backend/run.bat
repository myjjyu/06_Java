@ECHO off
CLS

윈도우:
json-server --watch .\data.json --port 3001 --static .\public


맥:
json-server --watch ./data.json --port 3001 --static ./public


pause

@REM watch : 데이타타입을 나타냄
