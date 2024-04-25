import psycopg2 as psql
from pprint import pprint
import os


file = os.path.join("secrets", ".psql.pass")
with open(file, "r") as file:
        password=file.read().rstrip()


conn_string="host=hadoop-04.uni.innopolis.ru port=5432 user=team27 dbname=team27_projectdb password={}".format(password)


with psql.connect(conn_string) as conn:

	cur = conn.cursor()
	with open(os.path.join("sql","create_tables.sql")) as file:
			content = file.read()
			cur.execute(content)
	conn.commit()
	
	# Read the commands from the file and execute them.
	with open(os.path.join("sql", "import_data.sql")) as file:
		# We assume that the COPY commands in the file are ordered (1.depts, 2.emps)
		commands= file.readlines()
		command1, copy_command, command2 = [], "", []
		for i, c in enumerate(commands):
			if c.strip()[:4].lower() == "copy":
				copy_command = c
				break
			command1.append(commands[i])
		for j, c in enumerate(commands[i + 1:]):
			command2.append(commands[j + i + 1])
		cur.execute('\n'.join(command1))
		with open(os.path.join("data","data.csv"), "r") as reviews:
			cur.copy_expert(copy_command, reviews)
		
		cur.execute('\n'.join(command2))


	conn.commit()

	pprint(conn)
	cur = conn.cursor()
	with open(os.path.join("sql", "test_database.sql")) as file:
		commands = file.readlines()
		for command in commands:
			cur.execute(command)
			pprint(cur.fetchall())