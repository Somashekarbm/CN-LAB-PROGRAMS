import socket
from pathlib import Path

def main():
	host = '127.0.0.1'
	port = 5555
	with socket.socket() as s:
		s.connect((host, port))
		print(f'Connected to server at https://{host}:{port}')
		filename = Path(input('Enter name of file to receive: ')).name
		s.sendall(filename.encode())
		with open(filename, 'wb') as file:
			while True:
				match s.recv(1024):
					case b'':
						break
					case data:
						file.write(data)

if __name__ == "__main__":
	main()
