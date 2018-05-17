### 오라클 디비 접속 및 암복호화 예제 파이썬

#### 설치 패키지
- `pip3 install cx_Oracle`
- `Oracle Instant Client` 다운로드 및 설치 (오라클 공식 페이지에서)
  - 참고  : http://cx-oracle.readthedocs.io/en/latest/installation.html#install-oracle-instant-client

#### 코드

```python

import sys
import os
os.chdir(/User/my/Documents/projects/oracle/instantclient_12_2)
import cx_Oracle

# 오라클 접속 정보
IP = '127.0.0.1'
PORT = '1825'
SVC_NAME = 'PYDEV'
ID = 'john'
PW = 'john123'

db = cx_Oracle.connect(ID, PW, cx_Oracle.makedsn(IP, PORT, service_name = SVC_NAME))
sql = """
  SELECT * FROM INFODB
  """
curs = db.cursor()
curs.execute(sql)

for row in curs:
  print(row)

# 키 정보
FRIST_256KEY = '256키'
SECOND_256KEY = '256키'
IV = '\x0f\x0e\r\x0c\x0b\n\t\x08\x07\x06\x05\x04\x03\x02\x01\x00'

BS = 16
pad = lambda s: s + (BS - len(s) % BS) * chr(BS - len(s) % BS).encode()
unpad = lambda s: s[:-ord(s[len(s)-1:])]


def decrypt(enc, key):
    enc = base64.b64decode(enc)
    cipher = AES.new(base64.b64decode(key), AES.MODE_CBC, IV)
    dec = cipher.decrypt(enc)
    return unpad(dec).decode('utf-8')


print(decrypt('암호문', FIRST_256KEY))
```
