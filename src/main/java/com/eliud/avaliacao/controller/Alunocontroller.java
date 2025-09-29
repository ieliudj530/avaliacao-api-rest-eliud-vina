package com.eliud.avaliacao.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class Alunocontroller {

    private List<String> alunos = new ArrayList<>();

    @GetMapping
    public List<String> listarAlunos() {
        return alunos;
    }

    @PostMapping
    public String adicionarAluno(@RequestBody String nome) {
        alunos.add(nome);
        return "Aluno " + nome + " adicionado com sucesso!";
    }

    @PutMapping("/{id}")
    public String atualizarAluno(@PathVariable int id, @RequestBody String novoNome) {
        if (id >= 0 && id < alunos.size()) {
            alunos.set(id, novoNome);
            return "Aluno atualizado para " + novoNome;
        } else {
            return "Aluno não encontrado.";
        }
    }

    @DeleteMapping("/{id}")
    public String deletarAluno(@PathVariable int id) {
        if (id >= 0 && id < alunos.size()) {
            String alunoRemovido = alunos.remove(id);
            return "Aluno " + alunoRemovido + " removido com sucesso!";
        } else {
            return "Aluno não encontrado.";
        }
    }
}
