/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Hide
 */
public class PaginationHandle extends SimpleTagSupport {

    private String uri;
    private int offset;
    private long count;
    private int steps;
    private String next = "Next";
    private String previous = "Previous";

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

            out.write("<nav>");
            out.write("<ul class=\"pagination\">");
            if (offset < steps) {
                out.write(constructLink(1, previous, "disabled", true));
            } else {
                out.write(constructLink(offset - steps, previous, null, false));
            }

            for (int index = 0; index < count; index += steps) {
                if (index == offset) {
                    //hiện tại trang đó đang được click vào (ví dụ: trang 5, trang 10)
                    out.write(constructLink(index, String.valueOf(index / steps + 1), "active", true));
                } else {
                    out.write(constructLink(index, String.valueOf(index / steps + 1), null, false));
                }
            }

            if (offset + steps >= count) {
                //button next không cho click nữa
                out.write(constructLink(offset + steps, next, "disabled", true));
            } else {
                out.write(constructLink(offset + steps, next, null, false));
            }

            out.write("</ul>");
            out.write("</nav>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in PaginationHandle tag", ex);
        }
    }

    private String constructLink(int page, String text, String className, boolean disable) {
        StringBuilder str = new StringBuilder("<li");
        if (className != null) {
            str.append(" class=\"").append(className).append("\"");
        }
        if (disable) {
            str.append("><a href=\"#\">").append(text).append("</a></li>");
        } else {
            str.append("><a href=\"").append(uri).append("?offset=").append(page).append("\">").append(text).append("</a></li>");
        }
        return str.toString();
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

}

