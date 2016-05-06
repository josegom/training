
import random
import base64
import codecs

def demutate2(s):
	demuted = ""

	try:
		demuted = base64.b64decode(bytes(s,"utf-8")).decode("utf-8") 		    
	except:		
		demuted = codecs.decode(s,'rot_13')

	return demuted


def demutate(s):
	demuted = ""
	if s.endswith("="):
		try:
			demuted = base64.b64decode(bytes(s,"utf-8")).decode("utf-8")
		except UnicodeDecodeError:
			demuted = codecs.decode(s,'rot_13')	
	else:
		demuted = codecs.decode(s,'rot_13')	
	
	return demuted


def main():

	with open('enc-0a8be8ec687f8ce9c3f7862cf7544d22.txt','r') as ecnc2:
		data=ecnc2.read()
	data=base64.b64decode(bytes(data,"utf-8")).decode("utf-8")
	for i in range(64):
		data = demutate2(data)

	with open('desc.txt','w') as desc:
		desc.write(data)

	print(data)


main()







	
	


