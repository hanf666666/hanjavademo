package com.file.easyexcel;

/**
 * @author Hj
 * @date 2026/4/22
 */
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;

public class DynamicHeadHandler implements CellWriteHandler {

    private final String dynamicTitle;

    public DynamicHeadHandler(String dynamicTitle) {
        this.dynamicTitle = dynamicTitle;
    }

    @Override
    public void beforeCellCreate(CellWriteHandlerContext context) {
        if (context.getHead()) {
            String headName = context.getHeadData().getHeadNameList()
                    .get(context.getRelativeRowIndex());

            if ("${title}".equals(headName)) {
                context.getHeadData().getHeadNameList()
                        .set(context.getRelativeRowIndex(), dynamicTitle);
            }
        }
    }
}
