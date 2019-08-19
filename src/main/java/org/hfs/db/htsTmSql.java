
package org.hfs.db;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

/** annotation ��� MyBatis ����� �̿��� ���̺� INSERT, SELECT ���� ����� �����ϴ� �������̽� 
 * @author �̿��� ( http://blog.naver.com/websearch )
 *
 */
public interface htsTmSql 
{
	@Insert("INSERT INTO "
			+ "hfstm     (   year,      month,      j_amt,      kb_amt,      wr_amt,      sh_amt,      ct_amt,      hn_amt,      nh_amt,      ex_amt,      etc_amt  ) "
			+ "VALUES(   #{m_year}, #{m_month}, #{m_j_amt}, #{m_kb_amt}, #{m_wr_amt}, #{m_sh_amt}, #{m_ct_amt}, #{m_hn_amt}, #{m_nh_amt}, #{m_ex_amt}, #{m_etc_amt} )")
	public void Insert( htsTmRow clsRow );
	
	@Update("UPDATE noticeboard SET nbSubject = #{m_strSubject}, nbContent = #{m_strContent} WHERE nbId = #{m_iId}" )
	public void Update( htsTmRow clsRow );
	
	@Update("UPDATE noticeboard SET nbReadCount = nbReadCount + 1 WHERE nbId = #{iId}")
	public void UpdateReadCount( int iId );
	
	@Update("UPDATE noticeboard SET nbCommentCount = nbCommentCount + 1 WHERE nbId = #{iId}")
	public void UpdateCommentCount( long iId );
	
	@Delete("DELETE FROM noticeboard WHERE nbId = #{iId}")
	public void Delete( int iId );
	
	@Select("SELECT nbId, nbSubject, nbInsertDate, nbReadCount, nbCommentCount FROM noticeboard ORDER BY nbId DESC")
	public List<htsTmSql> SelectList( int iPage );
	
	@Select("SELECT nbId, nbSubject, nbContent, nbInsertDate FROM noticeboard WHERE nbId = #{iId}")
	public List<htsTmSql> Select( int iId );
	
	@Insert("INSERT INTO noticeboardcomment( nbId, nbcComment, nbcInsertDate ) VALUES( #{m_iParentId}, #{m_strComment}, now() )")
	public void InsertComment( htsTmSql clsRow );
	
	@Select("SELECT nbcId, nbcComment, nbcInsertDate FROM noticeboardcomment WHERE nbId = #{iId} ORDER BY nbcId DESC")
	public List<htsTmSql> SelectCommentList( int iId );
}
