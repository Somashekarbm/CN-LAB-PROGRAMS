import socket
from pathlib import Path

def main():
	host = '127.0.0.1'
	port = 5555
	with socket.socket() as s:
		s.bind((host, port))
		print(f'File server is running on https://{host}:{port}')
		s.listen()
		conn, addr = s.accept()
		print(f'Connected to client at https://{addr[0]}:{addr[1]}')
		try:
			filename = Path(conn.recv(1024).decode().strip()).name
			with open(filename, 'rb') as f:
				for line in f:
					conn.sendall(line)
		except Exception as e:
			print(f'Error: {e}')

if __name__ == "__main__":
	main()
