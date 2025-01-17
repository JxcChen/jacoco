/*******************************************************************************
 * Copyright (c) 2009, 2018 Mountainminds GmbH & Co. KG and Contributors
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Marc R. Hoffmann - initial API and implementation
 *
 *******************************************************************************/
package org.jacoco.core.ast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jacoco.core.ast.structure.MyDiffInfo;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by kuohai on 2018/3/20.
 */

// 储存差异信息集合
public class DiffInfoGenerator {
    public String diff_str;
    public JSONObject json_obj;
    public List<MyDiffInfo> diffinfolist = null;
    private MyDiffInfo diff_info = null;

    public DiffInfoGenerator(String diff_str) {
        this.diff_str=diff_str;
        this.diffinfolist=new ArrayList<MyDiffInfo>();
        // 序列化diffJSON对象 并储存差异信息到列表中
        parseDiffJson();
    }
    // 序列化diffJSON对象
    private void parseDiffJson(){
        // 将json字符反序列化成对象
        json_obj= JSON.parseObject(diff_str);
        // 获取json中差异文件信息   转成jsonArray对象
        JSONArray json_sub01= (JSONArray)json_obj.get("diffJavaFileList");
        for(int i=0;i<json_sub01.size();i++){

                diff_info = new MyDiffInfo();
                JSONObject ob = (JSONObject) json_sub01.get(i);
                // 获取包名+类名
                diff_info.setClass_name((String) ob.get("javaFileDir"));
                // 获取差异行号
                JSONArray diffLinesList = (JSONArray) ob.get("diffLinesNum");

                for (int j = 0; j < diffLinesList.size(); j++) {
                    // 遍历差异行号  添加到 diffInfo中
                    int diffLineNum = (Integer) diffLinesList.get(j);
                    diff_info.chang_line_num.add(diffLineNum);
                }
                if(diff_info.getClass_name()!= null && diff_info.getClass_name() != "" && diff_info.getChang_line_num().size() != 0){
                    // 若存在差异信息 则将diffInfo存入与列表中
                    diffinfolist.add(diff_info);
                }
        }
    }
    public List<MyDiffInfo> getDiffinfolist() {
        return diffinfolist;
    }
}
