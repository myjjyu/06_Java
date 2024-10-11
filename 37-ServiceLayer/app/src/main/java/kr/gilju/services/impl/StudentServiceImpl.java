package kr.gilju.services.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.gilju.exceptions.ServiceNoResultException;
import kr.gilju.models.Professor;
import kr.gilju.models.Student;
import kr.gilju.services.StudentService;


/**
 * 학과 관리 기능과 관련된 MyBatis Mapper를 간접적으로 호출하기 위한 기능 명세
 * 
 * 1) 모든 메서드를 재정의 한 직후 리턴값 먼저 정의
 */
public class StudentServiceImpl implements StudentService {

  // 2) MyBatis의 Mapper를 호출하기 위한 SqlSession 객체
  // --> import org.apache.ibatis.session.SqlSession;
  private SqlSession sqlSession;

  // 3) 생성자를 정의하여 SqlSession을 전달받는다
  public StudentServiceImpl(SqlSession sqlSession) {
      this.sqlSession = sqlSession;
  }

  @Override
  public Student addItem(Student params) throws ServiceNoResultException, Exception {
    Student result = null;

      // insert문 수행
      // 리턴되는 값은 저장된 데이터의 수
      // 생성된 pk는 파라미터로 전달된 parmas 객체의 적절한 멤버변수에 설정된다 --> getter를 통해 취득 가능함

      int rows = sqlSession.insert("StudentMapper.insert", params);

      if (rows == 0) {
          throw new ServiceNoResultException("저장된 데이터가 없습니다");
      }

      // params에 설정된 pk값을 활용하여 저장된 내용을 그대로 조회한다
      result = sqlSession.selectOne("StudentMapper.selectItem", params);

      return result;
  }

  @Override
  public Student editItem(Student params) throws ServiceNoResultException, Exception {
    Student result = null;

      // update 문 수행 -> 리턴되는 값은 수정된 데이터의 수
      int rows = sqlSession.update("StudentMapper.update", params);

      // 수정된 데이터가 없다면?
      if (rows == 0) {
          // 객체가 없다는 내용의 에러를 강제 발생시킴
          throw new ServiceNoResultException("수정된 데이터가 없습니다");
      }

      // 수정된 결과를 조회한다
      result = sqlSession.selectOne("StudentMapper.selectItem", params);


      return result;
  }

  @Override
  public int deleteItem(Student params) throws ServiceNoResultException, Exception {
      int result = 0;

      // 학과 데이터 삭제를 위한 참조관계에 있는 자식 데이터를 순서대로 삭제
      Professor professor = new Professor();
      professor.setDeptno(params.getDeptno());
      sqlSession.delete("ProfessorMapper.deleteByDeptno", professor);

      // delete문 수행 -> 리턴되는 값은 수정된 데이터의 수
      result = sqlSession.delete("StudentMapper.delete", params);

      // 삭제된 데이터가 없다면?
      if (result == 0) {
          // 객체가 없다는 내용의 에러를 강제 발생시킴
          throw new ServiceNoResultException("삭제된 데이터가 없습니다");
      }

      return result;
  }

  @Override
  public Student getItem(Student params) throws ServiceNoResultException, Exception {
    Student result = null;

      result = sqlSession.selectOne("StudentMapper.selectItem", params);

      if (result == null) {
          // 객체가 없다는 내용의 에러를 강제 발생시킴
          throw new ServiceNoResultException("조회된 데이터가 없습니다");
      }

      return result;
  }

  @Override
  public List<Student> getList(Student params) throws ServiceNoResultException, Exception {
      return sqlSession.selectList("StudentMapper.selectList", params);
  }
}
