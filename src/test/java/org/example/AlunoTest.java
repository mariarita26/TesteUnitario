package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {
    @Test
    public void NaoDeveAlterarMatriculaSemTer11Digitos(){
        Aluno aluno = new Aluno(1, "Maria", 22, "20211370005", "256");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("2021137"));
    }

    @Test
    public void NaoDeveAlterarMatriculaSeConterCaracterEspecial(){
        Aluno aluno = new Aluno(1, "Maria", 22, "12345678912", "256");
        Assertions.assertThrows(RuntimeException.class, () -> aluno.setMatricula("123456789!@"));
    }


}
