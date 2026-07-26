class univer
    def __init__(self, nome="", cnpj="", endereco=""):
        self.nome = nome
        self.cnpj = cnpj
        self.departments = []
        
        def __str__(self):
            depts = '\n  '.join(str(dept) for dept in self.departments)
            return f"Universidade: {self.nome}"