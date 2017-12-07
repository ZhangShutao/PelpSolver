package cn.edu.seu.kse.translate;

import cn.edu.seu.kse.exception.TranslateErrorException;
import cn.edu.seu.kse.model.BaseObjectModel;

import java.util.Set;

/**
 * 翻译器的通用接口
 *
 * @author 张舒韬
 * @date 2017/1/17
 */
public interface ProgramTranslator {
    /**
     * 翻译任意语法单元
     * @param objectModel 待翻译的语法单元
     * @return 翻译所得的语法单元集合
     * @throws TranslateErrorException failed to translate
     */
    Set<BaseObjectModel> translate(BaseObjectModel objectModel) throws TranslateErrorException;

    /**
     * 将逻辑程序翻译成另一形式的逻辑程序
     * @param program 待翻译的逻辑程序
     * @return 翻译所得的逻辑程序
     * @throws TranslateErrorException failed to translate
     */
    BaseObjectModel translateProgram(BaseObjectModel program) throws TranslateErrorException;
}
